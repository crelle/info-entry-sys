package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.pojo.entity.Menu;
import baseline.sysmgmt.pojo.entity.Role;
import baseline.sysmgmt.mapper.RoleMapper;
import baseline.sysmgmt.pojo.entity.RoleMenu;
import baseline.sysmgmt.pojo.query.RoleQuery;
import baseline.sysmgmt.pojo.vo.RoleVo;
import baseline.sysmgmt.service.RoleMenuService;
import baseline.sysmgmt.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMenuService roleMenuService;

    @Transactional
    @Override
    public boolean create(Role object) {
        //插入角色信息
        save(object);
        insertRoleMenu(object);
        return true;
    }

    private void insertRoleMenu(Role object) {
        //插入角色菜单信息
        List<Menu> menuList = object.getMenus();
        if (menuList.isEmpty()) {
            return;
        }
        for (Menu menu : menuList) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setId(UUID.randomUUID().toString());
            roleMenu.setMenuId(menu.getId());
            roleMenu.setRoleId(object.getId());
            roleMenu.setCreateTime(new Date());
            roleMenuService.save(roleMenu);
        }
    }

    @Override
    public Role queryById(String id) {
        return getById(id);
    }

    @Override
    public List<Role> queryAll() {
        return list();
    }

    @Override
    public boolean update(Role object) {
        return updateById(object);
    }

    @Transactional
    @Override
    public boolean deleteById(String id) {
        removeById(id);
        deleteRoleMenu(id);
        return true;
    }

    private void deleteRoleMenu(String id) {
        List<String> list = roleMenuService
                .queryAll()
                .stream()
                .filter(roleMenu -> roleMenu.getRoleId().equals(id))
                .map(RoleMenu::getId)
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            return;
        }
        for (String roleMenuId : list) {
            roleMenuService.deleteById(roleMenuId);
        }
    }

    @Override
    public Page<Role> page(Page<Role> page) {
        LambdaQueryWrapper<Role> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (!CollectionUtils.isEmpty(page.getRecords())) {
            Role role = page.getRecords().get(0);
            lambdaQueryWrapper.like(StringUtils.isNotBlank(role.getNameZh()), Role::getNameZh, role.getNameZh());
        }
        return super.page(page, lambdaQueryWrapper);
    }

    @Override
    public Page<RoleVo> manualPage(Page<RoleQuery> pageBean) {
        return null;
    }

    @Override
    public List<Role> queryByNameZh(String roleNameZh) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("name_zh", roleNameZh);
        return list(queryWrapper);
    }

    @Override
    public List<Role> queryByName(String roleName) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("name", roleName);
        return list(queryWrapper);
    }
}
