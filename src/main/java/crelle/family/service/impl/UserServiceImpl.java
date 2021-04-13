package crelle.family.service.impl;

import crelle.family.common.ResponseResult;
import crelle.family.common.util.ResultUtils;
import crelle.family.mapper.UserMapper;
import crelle.family.model.PageBean;
import crelle.family.model.ao.UserAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public User create(User user) {
        return userDao.save(user);
    }

    @Override
    public Optional<User> queryById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public Page<User> pageByCondition(PageBean<UserAO> pageBean) {
        return null;
    }

    @Override
    public List<User> queryAll() {
        return userDao.findAll();
    }

    @Override
    public int update(Long id, User user) {
        if (null == userDao.findById(id)) {
            return 0;
        }
        userDao.save(user);
        return 1;
    }

    @Override
    public void deleteById(Long id) {
        //先查询后删除，不然无法删除
        Optional<User> user = userDao.findById(id);
        userDao.deleteById(user.get().getId());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }


    @Override
    public User findUserByUsernameAndPassword(UserAO userAO) {
        User user = userDao.findUserByUsernameAndPassword(userAO.getUsername(), userAO.getPassword());
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }

    @Override
    public List<User> findUsersByUsername(String username) {
        return userDao.findUsersByUsername(username);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }
}
