package baseline.sysmgmt.service.impl;

import baseline.common.ResponseResult;
import baseline.sysmgmt.pojo.entity.Menu;
import baseline.sysmgmt.mapper.MenuMapper;
import baseline.sysmgmt.service.MenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    public boolean create(Menu object) {
        return save(object);
    }

    @Override
    public Menu queryById(String id) {
        return getById(id);
    }

    @Override
    public List<Menu> queryAll() {
        return list();
    }

    @Override
    public boolean update(Menu object) {
        return updateById(object);
    }

    @Override
    public void deleteById(String id) {
        removeById(id);
    }

    @Override
    public Page<Menu> pageByCondition(Page<Menu> page) {
        return page(page);
    }

    @Override
    public Menu queryByName(String menuName) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("name", menuName);
        return getOne(queryWrapper);
    }

    @Override
    public ResponseResult<String> updateParentMenu(List<Menu> menus) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        if (menus.isEmpty()) {
            return responseResult;
        }
        try {
            for (Menu menu : menus) {
                Menu oldMenu = queryById(menu.getId());
                if (null == oldMenu) {
                    responseResult.buildFail("要更新的菜单不存在！");
                    return responseResult;
                }
                Menu newMenu = new Menu();
                newMenu.setId(menu.getId());
                newMenu.setParentId(menu.getParentId());
                if (!isParentMenuExist(newMenu)) {
                    responseResult.buildFail("要更新的父菜单不存在！");
                    return responseResult;
                }
                if (newMenu.getParentId() != null && newMenu.getId().equals(newMenu.getParentId())) {
                    responseResult.buildFail("子目录和父目录不能相同！");
                }

                boolean isSuccess = lambdaUpdate().eq(Menu::getId, newMenu.getId())
                        .set(Menu::getParentId, newMenu.getParentId())
                        .update();
                if (!isSuccess) {
                    responseResult.buildFail("更新菜单失败！");
                }
            }

        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @Override
    public ResponseResult<List<Menu>> queryAllMenus() {
        ResponseResult<List<Menu>> responseResult = new ResponseResult<>();
        try {
            List<Menu> menus = queryAll();
            List<Menu> resultMenus = menus
                    .stream()
                    .filter(menu -> menu.getParentId() == null)
                    .sorted(Comparator.comparing(Menu::getMenuSort))
                    .collect(Collectors.toList());

            for (Menu menu : menus) {
                QueryWrapper<Menu> wrapper = new QueryWrapper<>();
                wrapper.select().eq("parent_id", menu.getId());
                Set<Menu> secondMenus = new HashSet<>(list(wrapper));
                menu.setChildrenMenus(secondMenus);
            }

            responseResult.setData(resultMenus);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    private boolean isParentMenuExist(Menu menu) {
        if (menu.getParentId() != null) {
            Menu parentMenu = queryById(menu.getParentId());
            if (parentMenu == null) {
                return false;
            }
        }
        return true;
    }


}
