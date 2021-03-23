package plant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plant.dao.RoleDao;
import plant.model.entity.Role;
import plant.service.RoleService;

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
    public Role addRole(Role role) {
        return roleDao.save(role);
    }

    @Override
    public List<Role> queryRoles() {
        return roleDao.findAll();
    }

    @Override
    public Optional<Role> queryRoleById(Long id) {
        return roleDao.findById(id);
    }

    @Override
    public void deleteRoleById(Long id) {
        roleDao.deleteById(id);
    }
}
