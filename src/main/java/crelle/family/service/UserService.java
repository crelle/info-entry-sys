package crelle.family.service;

import crelle.family.model.ao.UserAO;
import crelle.family.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

/**
 * @author:crelle
 * @className:UserService
 * @version:1.0.0
 * @date:2021/3/23
 * @description:XX
 **/
public interface UserService extends UserDetailsService, BaseService<User, UserAO> {

    User findUserByUsernameAndPassword(UserAO userAO);
}
