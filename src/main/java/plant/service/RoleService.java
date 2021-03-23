package plant.service;

import plant.model.entity.Role;

import java.util.List;
import java.util.Optional;

/**
 * @author:crelle
 * @className:RoleService
 * @version:1.0.0
 * @date:2021/3/23
 * @description:XX
 **/
public interface RoleService {


    Role addRole(Role role);

    List<Role> queryRoles();

    Optional<Role> queryRoleById(Long id);

    void deleteRoleById(Long id);


}
