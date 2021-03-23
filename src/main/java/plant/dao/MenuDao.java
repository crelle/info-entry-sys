package plant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import plant.model.entity.Menu;

/**
 * @author:crelle
 * @className:MenuDao
 * @version:1.0.0
 * @date:2021/3/22
 * @description:XX
 **/
public interface MenuDao extends JpaRepository<Menu,Long> {

}
