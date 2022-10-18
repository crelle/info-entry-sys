package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.mapper.UserMapper;
import baseline.sysmgmt.model.entity.*;
import baseline.sysmgmt.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean create(User object) {
        object.setPassword(passwordEncoder.encode(object.getPassword()));
        return save(object);
    }

    @Override
    public User queryById(String id) {
        return getById(id);
    }

    @Override
    public List<User> queryAll() {
        return list();
    }

    @Override
    public boolean update(User object) {
        return updateById(object);
    }

    @Override
    public void deleteById(String id) {
        removeById(id);
    }

    @Override
    public Page<User> pageByCondition(Page<User> page) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (CollectionUtils.isNotEmpty(page.getRecords())) {
            User request = page.getRecords().get(0);
            queryWrapper.select().eq("account_non_expired", request.isAccountNonExpired())
                    .eq("account_non_locked", request.isAccountNonLocked())
                    .eq("enabled", request.isEnabled())
                    .like("user_phone", request.getUserPhone())
                    .like("username", request.getUsername());
        }
        return page(page, queryWrapper);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //查询用户
        QueryWrapper<User> queryWrapper = Wrappers.<User>query().eq("username", userName);
        User result = getOne(queryWrapper);
        //查询用户角色
        QueryWrapper<UserRole> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.select("role_id").eq("user_id", result.getId());
        List<String> roleIds = userRoleService.list(queryWrapper1).stream().map(UserRole::getRoleId).collect(Collectors.toList());
        //查询角色
        QueryWrapper<Role> queryWrapper2 = Wrappers.<Role>query().in("id", roleIds);
        List<Role> rolelist = roleService.list(queryWrapper2);
        //为角色组装菜单
        rolelist.forEach(role -> {
            //根据角色id查询菜单集合
            QueryWrapper queryWrapper3 = new QueryWrapper();
            queryWrapper3.select().eq("role_id", role.getId());
            List<RoleMenu> roleMenus = roleMenuService.list(queryWrapper3);
            //查询菜单表
            List<Menu> menus = menuService.listByIds(roleMenus.stream().map(RoleMenu::getMenuId).collect(Collectors.toList()));
            //组装子菜单
            menus.forEach(menu -> {
                QueryWrapper<Menu> queryWrapper4 = new QueryWrapper<>();
                queryWrapper4.select().eq("parent_id", menu.getId());
                List<Menu> menus1 = menuService.list(queryWrapper4);
                Set<Menu> menus2 = new HashSet<>(menus1);
                menu.setChildrenMenus(menus2);

            });
            role.setMenus(menus);
        });


        if (result == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        result.setRoles(rolelist);
        return result;
    }
}
