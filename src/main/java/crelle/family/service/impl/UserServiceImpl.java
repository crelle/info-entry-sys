package crelle.family.service.impl;

import crelle.family.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import crelle.family.dao.UserDao;
import crelle.family.model.entity.User;
import crelle.family.service.UserService;

import java.util.List;
import java.util.Optional;

/**
 * @author:crelle
 * @date:2021/3/18
 * @title:
 * @description:
 * @params:
 * @return:
 * @throw:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Autowired(required = false)
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }

    public User addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUserById(user);
    }

    @Override
    public List<User> queryUsers() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> queryUserById(Long id) {
        return userDao.findById(id);
    }
}
