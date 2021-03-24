package plant.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import plant.model.entity.User;
import plant.model.entity.UserForMyBaties;

import java.util.List;
import java.util.Optional;

/**
 * @author:crelle
 * @className:UserService
 * @version:1.0.0
 * @date:2021/3/23
 * @description:XX
 **/
public interface UserService extends UserDetailsService {

    User addUser(User user);

    void deleteUserById(Long id);

    int updateUser(User user);

    List<User> queryUsers();

    Optional<User> queryUserById(Long id);


}
