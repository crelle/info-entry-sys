package crelle.family.dao;

import crelle.family.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author:crelle
 * @className:RoleDao
 * @version:1.0.0
 * @date:2021/3/23
 * @description:XX
 **/
public interface RoleDao extends JpaRepository<Role,Long> {
}
