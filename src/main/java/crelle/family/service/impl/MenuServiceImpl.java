package crelle.family.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import crelle.family.dao.MenuDao;
import crelle.family.model.entity.Menu;
import crelle.family.service.MenuService;

import java.util.List;

/**
 * @author:crelle
 * @className:MenuServiceImpl
 * @version:1.0.0
 * @date:2021/3/22
 * @description:XX
 **/
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public Menu saveMenu(Menu menu) {
        return menuDao.save(menu);
    }

    @Override
    public List<Menu> saveMenus(List<Menu> menus) {
        return menuDao.saveAll(menus);
    }

    @Override
    public void deleteMenus() {
        menuDao.deleteAll();
    }

    @Override
    public void deleteMenuById(Long id) {
        menuDao.deleteById(id);
    }

    @Override
    public void deleteMenus(List<Menu> menus) {
        menuDao.deleteAll(menus);
    }

    @Override
    public List<Menu> queryMenuByRoleId(String roleId) {
        return menuDao.
    }

    @Override
    public List<Menu> queryMenus() {
        return menuDao.findAll();
    }

}
