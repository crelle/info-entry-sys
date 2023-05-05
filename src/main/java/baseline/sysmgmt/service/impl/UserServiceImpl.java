package baseline.sysmgmt.service.impl;

import baseline.app.service.DepartmentService;
import baseline.common.enumeration.ResponseEnum;
import baseline.common.exception.BusinessException;
import baseline.sysmgmt.mapper.UserMapper;
import baseline.sysmgmt.pojo.entity.*;
import baseline.sysmgmt.pojo.query.UserQuery;
import baseline.sysmgmt.pojo.vo.UserVo;
import baseline.sysmgmt.service.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private UserMapper userMapper;

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
    @Transactional(rollbackFor = Exception.class)
    public boolean update(User object) {
        try {
            //删除用户角色
            userRoleService.deleteByUserId(object.getId());
            List<Role> roles = object.getRoles();
            List<UserRole> userRoles = new ArrayList<>();
            //组装用户角色
            if (CollectionUtils.isNotEmpty(roles)) {
                roles.forEach(role -> {
                    UserRole userRole = new UserRole();
                    userRole.setUserId(object.getId());
                    userRole.setRoleId(role.getId());
                    userRoles.add(userRole);
                });
            }
            //新增用户角色
            userRoleService.addSelective(userRoles);
            //更新用户信息
            updateById(object);
        } catch (Exception e) {
            throw new BusinessException(ResponseEnum.FAIL);
        }

        return true;
    }

    @Override
    public boolean deleteById(String id) {
        return removeById(id);
    }


    @Override
    public Page<User> page(Page<User> page) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (CollectionUtils.isNotEmpty(page.getRecords())) {
            User user = page.getRecords().get(0);
            lambdaQueryWrapper.eq(User::isAccountNonExpired, user.isAccountNonExpired())
                    .eq(User::isAccountNonLocked, user.isAccountNonLocked())
                    .eq(User::isEnabled, user.isEnabled())
                    .like(StringUtils.isNotBlank(user.getUsername()), User::getUsername, user.getUsername())
                    .like(StringUtils.isNotBlank(user.getUserPhone()), User::getUserPhone, user.getUserPhone())
                    .orderByDesc(User::getUpdateTime);
        }
        Page<User> userPage = super.page(page, lambdaQueryWrapper);
        userPage.getRecords().forEach(user -> {
            //查询用户角色
            QueryWrapper<UserRole> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.select("role_id").eq("user_id", user.getId());
            List<String> roleIds = userRoleService.list(queryWrapper1).stream().map(UserRole::getRoleId).collect(Collectors.toList());
            //查询角色
            QueryWrapper<Role> queryWrapper2 = Wrappers.<Role>query().in("id", roleIds);
            List<Role> rolelist = roleService.list(queryWrapper2);
            user.setRoles(rolelist);
        });
        return userPage;
    }

    @Override
    public Page<UserVo> manualPage(Page<UserQuery> userQueryPage) {
        UserQuery userQuery = userQueryPage.getRecords().get(0);

        Page<UserVo> page = new Page<>();
        List<UserVo> userVos = userMapper.manualPage(userQuery);
        PageInfo<UserVo> pageInfo = new PageInfo<>(userVos);
        userVos.forEach(user -> {
            //查询用户角色
            QueryWrapper<UserRole> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.select("role_id").eq("user_id", user.getId());
            List<String> roleIds = userRoleService.list(queryWrapper1).stream().map(UserRole::getRoleId).collect(Collectors.toList());
            //查询角色
            QueryWrapper<Role> queryWrapper2 = Wrappers.<Role>query().in("id", roleIds);
            List<Role> rolelist = roleService.list(queryWrapper2);
            user.setRoles(rolelist);
        });
        page.setRecords(userVos);
        page.setTotal(pageInfo.getTotal());
        return page;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //查询用户
        QueryWrapper<User> queryWrapper = Wrappers.<User>query().eq("username", userName);
        User result = getOne(queryWrapper);
        if (result == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
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
            LambdaQueryWrapper<RoleMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.select().eq(RoleMenu::getRoleId, role.getId());
            List<RoleMenu> roleMenus = roleMenuService.list(lambdaQueryWrapper);
            //查询菜单表
            List<Menu> menus = menuService.listByIds(roleMenus.stream().map(RoleMenu::getMenuId).collect(Collectors.toList()));
            //过滤出父菜单
            List<Menu> parentMenus = menus.stream().filter(menu -> {
                return StringUtils.isBlank(menu.getParentId());
            }).collect(Collectors.toList());
            //组装子菜单
            parentMenus.forEach(menu -> {
                QueryWrapper<Menu> queryWrapper4 = new QueryWrapper<>();
                queryWrapper4.select().eq("parent_id", menu.getId());
                List<Menu> menus1 = menuService.list(queryWrapper4);
                Set<Menu> menus2 = new HashSet<>(menus1);
                menu.setChildrenMenus(menus2);

            });
            role.setMenus(parentMenus);
        });


        result.setRoles(rolelist);
        return result;
    }

    @Override
    public int updatePasswordById(String password, User user) {
        String userId = user.getId();
        User user1 = queryById(userId);
        String oldPassword = user1.getPassword();
        if (!passwordEncoder.matches(user.getPassword(), oldPassword)) {
            return 0;
        }
        return userMapper.updatePasswordById((passwordEncoder.encode(password)), user.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int resetPassword(String userId) {
        if (null == userMapper.selectById(userId)) {
            throw new BusinessException("用户不存在!");
        }

        return userMapper.resetPassword(userId, passwordEncoder.encode("123456"));
    }
}
