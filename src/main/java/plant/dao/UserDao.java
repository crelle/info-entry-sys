package plant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import plant.model.entity.User;

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
