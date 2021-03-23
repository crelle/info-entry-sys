package plant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import plant.model.entity.Menu;
import plant.model.entity.Role;

/**
 * @author:crelle
 * @className:RoleDao
 * @version:1.0.0
 * @date:2021/3/23
 * @description:XX
 **/
public interface RoleDao extends JpaRepository<Role,Long> {
}
