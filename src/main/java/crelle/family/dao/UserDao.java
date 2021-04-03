package crelle.family.dao;

import crelle.family.model.entity.Menu;
import crelle.family.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *@author:crelle
 *@date:2021/3/18
 *@title:
 *@description:
 *@params:
 *@return:
 *@throw:
 */
public interface UserDao extends JpaRepository<User,Long>, JpaSpecificationExecutor<Menu> {
    User  findUserByUsername(String username);
}
