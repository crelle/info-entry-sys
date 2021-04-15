package crelle.family.dao;

import crelle.family.model.entity.Menu;
import crelle.family.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Set;

/**
 * @author:crelle
 * @className:RoleDao
 * @version:1.0.0
 * @date:2021/3/23
 * @description:XX
 **/
public interface RoleDao extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Menu> {

    Set<Role> findRolesByName(String name);

}
