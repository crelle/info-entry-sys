package crelle.family.service.impl;

import crelle.family.common.ResponseResult;
import crelle.family.common.util.ResultUtils;
import crelle.family.mapper.UserMapper;
import crelle.family.model.PageBean;
import crelle.family.model.ao.UserAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
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
    public User queryById(Long id) {
        return userDao.findById(id).get();
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
        Optional<User> userOpt = userDao.findById(id);
        if (!userOpt.isPresent()) {
            return 0;
        }
        User userOld = userOpt.get();
        //忽略id和roles属性的拷贝,不然会报id为null错误导致无法更新
        BeanUtils.copyProperties(user,userOld,"id","roles");
        userDao.save(userOld);
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
