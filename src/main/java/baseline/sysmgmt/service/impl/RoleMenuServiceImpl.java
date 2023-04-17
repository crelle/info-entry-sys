package baseline.sysmgmt.service.impl;

import baseline.common.enumeration.ResponseEnum;
import baseline.common.exception.BusinessException;
import baseline.common.pojo.vo.ResponseResult;
import baseline.sysmgmt.pojo.entity.Menu;
import baseline.sysmgmt.pojo.entity.Role;
import baseline.sysmgmt.pojo.entity.RoleMenu;
import baseline.sysmgmt.mapper.RoleMenuMapper;
import baseline.sysmgmt.pojo.query.RoleMenuQuery;
import baseline.sysmgmt.pojo.vo.RoleMenuVo;
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
    public boolean deleteById(String id) {
        return removeById(id);
    }

    @Override
    public Page<RoleMenu> page(Page<RoleMenu> page) {
        return super.page(page);
    }

    @Override
    public Page<RoleMenuVo> manualPage(Page<RoleMenuQuery> pageBean) {
        return null;
    }

    @Override
    public ResponseResult<List<Menu>> queryMenu(Role role) {
        ResponseResult<List<Menu>> responseResult = ResponseResult.ok();
        try {
            List<Menu> menus = getRoleMenu(role);
            responseResult.setData(menus);
        } catch (Exception e) {
            throw new BusinessException(ResponseEnum.UNKNOWN);
        }
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

    @Transactional(rollbackFor = Exception.class)
    public void updateRoleMenu(Role role) {
        try {
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
        } catch (Exception e) {
            throw new BusinessException(ResponseEnum.UNKNOWN);
        }

    }

    private void saveMenu(String roleId, String menuId) {
        RoleMenu roleMenu = new RoleMenu();
        roleMenu.setMenuId(menuId);
        roleMenu.setRoleId(roleId);
        create(roleMenu);
    }

}
