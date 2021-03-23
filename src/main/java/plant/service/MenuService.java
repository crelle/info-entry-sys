package plant.service;

import plant.model.entity.Menu;

import java.util.List;

/**
 * @author:crelle
 * @className:MenuService
 * @version:1.0.0
 * @date:2021/3/22
 * @description:XX
 **/
public interface MenuService {

    Menu saveMenu(Menu menu);

    List<Menu> saveMenus(List<Menu> menus);

    void deleteMenus();

    void deleteMenuById(Long id);

    void deleteMenus(List<Menu> menus);

    List<Menu> queryMenuByRoleId();

    List<Menu> queryMenus();

}
