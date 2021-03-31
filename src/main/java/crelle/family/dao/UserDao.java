package crelle.family.dao;

import crelle.family.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *@author:crelle
 *@date:2021/3/18
 *@title:
 *@description:
 *@params:
 *@return:
 *@throw:
 */
public interface UserDao extends JpaRepository<User,Long> {
    User  findUserByUsername(String username);
}
