package crelle.family.dao;

import crelle.family.model.entity.Menu;
import crelle.family.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author:crelle
 * @className:MenuDao
 * @version:1.0.0
 * @date:2021/3/22
 * @description:XX
 **/
public interface MenuDao extends JpaRepository<Menu,Long>, JpaSpecificationExecutor<Menu> {

    List<Menu> findMenusByName(String name);

}
