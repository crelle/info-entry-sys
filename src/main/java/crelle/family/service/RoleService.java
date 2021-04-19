package crelle.family.service;

import crelle.family.model.ao.RoleAO;
import crelle.family.model.entity.Role;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author:crelle
 * @className:RoleService
 * @version:1.0.0
 * @date:2021/3/23
 * @description:XX
 **/
public interface RoleService extends BaseService<Role, RoleAO> {

    Set<Role> findRolesByName(String name);


}
