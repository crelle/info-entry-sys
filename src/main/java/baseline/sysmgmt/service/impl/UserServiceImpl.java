package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.mapper.UserMapper;
import baseline.sysmgmt.model.entity.*;
import baseline.sysmgmt.service.*;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public boolean create(User object) {
        return save(object);
    }

    @Override
    public User queryById(Long id) {
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
    public void deleteById(Long id) {
        removeById(id);
    }

    @Override
    public IPage<User> pageByCondition(IPage<User> page) {
        return page(page);
    }

    @Override
    public IPage<User> pageByCondition(IPage<User> page, Wrapper<User> queryWrapper) {
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
        List<Long> roleIds = userRoleService.list(queryWrapper1).stream().map(UserRole::getRoleId).collect(Collectors.toList());
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
            role.setMenus(menus);
        });


        if (result == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        result.setRoles(rolelist);
        return result;
    }
}
