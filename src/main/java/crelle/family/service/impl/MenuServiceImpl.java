package crelle.family.service.impl;

import crelle.family.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import crelle.family.dao.MenuDao;
import crelle.family.model.entity.Menu;
import crelle.family.service.MenuService;

import java.util.List;
import java.util.Optional;

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
    public Menu create(Menu role) {
        return menuDao.save(role);
    }

    @Override
    public Optional<Menu> queryById(Long id) {
        return menuDao.findById(id);
    }

    @Override
    public List<Menu> queryAll() {
        return menuDao.findAll();
    }

    @Override
    public int update(Long id, Menu menu) {
        if (null == menuDao.findById(id)) {
            return 0;
        }
        menuDao.save(menu);
        return 1;
    }

    @Override
    public void deleteById(Long id) {
        menuDao.deleteById(id);
    }
}
