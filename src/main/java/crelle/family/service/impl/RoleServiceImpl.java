package crelle.family.service.impl;

import crelle.family.dao.RoleDao;
import crelle.family.model.PageBean;
import crelle.family.model.ao.RoleAO;
import crelle.family.model.entity.Role;
import crelle.family.service.BaseService;
import crelle.family.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author:crelle
 * @className:RoleServiceImpl
 * @version:1.0.0
 * @date:2021/3/23
 * @description:XX
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role create(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Role queryById(Long id) {
        return roleDao.findById(id).get();
    }



    @Override
    public List<Role> queryAll() {
        return roleDao.findAll();
    }

    @Override
    public Page<Role> pageByCondition(PageBean<RoleAO> pageBean) {
        return null;
    }

    @Override
    public int update(Long id, Role role) {
        if (null == roleDao.findById(id)) {
            return 0;
        }
        roleDao.save(role);
        return 1;
    }

    @Override
    public void deleteById(Long id) {
        roleDao.deleteById(id);
    }

    @Override
    public List<Role> findRolesByName(String name) {
        return roleDao.findRolesByName(name);
    }

}
