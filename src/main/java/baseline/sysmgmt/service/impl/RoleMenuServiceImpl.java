package baseline.sysmgmt.service.impl;

import baseline.common.ResponseResult;
import baseline.sysmgmt.pojo.entity.Menu;
import baseline.sysmgmt.pojo.entity.Role;
import baseline.sysmgmt.pojo.entity.RoleMenu;
import baseline.sysmgmt.mapper.RoleMenuMapper;
import baseline.sysmgmt.service.RoleMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
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
@Transactional
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
    @Autowired
    private MenuServiceImpl menuService;

    @Override
    public boolean create(RoleMenu object) {
        return save(object);
    }

    @Override
    public RoleMenu queryById(String id) {
        return getById(id);
    }

    @Override
    public List<RoleMenu> queryAll() {
        return list();
    }

    @Override
    public boolean update(RoleMenu object) {
        return updateById(object);
    }

    @Override
    public void deleteById(String id) {
        removeById(id);
    }

    @Override
    public Page<RoleMenu> pageByCondition(Page<RoleMenu> page) {
        return page(page);
    }

    @Override
    public ResponseResult<Role> queryMenu(Role role) {
        List<Menu> menus = getRoleMenu(role);

        ResponseResult<Role> responseResult = new ResponseResult<>();
        Role roleResp = new Role();
        roleResp.setId(role.getId());
        roleResp.setName(role.getName());
        roleResp.setNameZh(role.getNameZh());
        roleResp.setMenus(menus);
        responseResult.setData(roleResp);
        return responseResult;
    }

    private List<Menu> getRoleMenu(Role role) {
        QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
        wrapper.select().eq("role_id", role.getId());
        List<RoleMenu> roleMenus = list(wrapper);

        return roleMenus
                .stream()
                .map(RoleMenu::getMenuId)
                .map(menuId -> menuService.queryById(menuId))
                .collect(Collectors.toList());
    }

    public void updateRoleMenu(Role role) {
        if (null == role) {
            return;
        }

        //删除关联表
        QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
        wrapper.select().eq("role_id", role.getId());
        remove(wrapper);

        if (role.getMenus().isEmpty()) {
            return;
        }
        //插入新增关联表
        role.getMenus()
                .stream()
                .filter(Objects::nonNull)
                .forEach(menu -> saveMenu(role.getId(), menu.getId()));
    }

    private void saveMenu(String roleId, String menuId) {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setMenuId(menuId);
        roleMenu.setRoleId(roleId);
        create(roleMenu);
    }

}
