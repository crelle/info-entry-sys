package crelle.family.service.impl;

import crelle.family.common.ResponseResult;
import crelle.family.common.util.ResultUtils;
import crelle.family.mapper.UserMapper;
import crelle.family.model.PageBean;
import crelle.family.model.ao.UserAO;
import crelle.family.model.entity.Role;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import crelle.family.dao.UserDao;
import crelle.family.model.entity.User;
import crelle.family.service.UserService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                if (StringUtils.isNotBlank(pageBean.getCondition().getUserPhone())) {
                    Predicate predicate1 = criteriaBuilder.equal(root.get("userPhone"), pageBean.getCondition().getUserPhone());
                    predicate.getExpressions().add(predicate1);
                }
                if (StringUtils.isNotBlank(pageBean.getCondition().getUsername())) {
                    Predicate predicate2 = criteriaBuilder.equal(root.get("username"), pageBean.getCondition().getUsername());
                    predicate.getExpressions().add(predicate2);
                }
                Predicate predicate3 = criteriaBuilder.equal(root.get("enabled"), pageBean.getCondition().isEnabled());
                predicate.getExpressions().add(predicate3);

                Predicate predicate4 = criteriaBuilder.equal(root.get("accountNonLocked"), pageBean.getCondition().isAccountNonLocked());
                predicate.getExpressions().add(predicate4);

                Predicate predicate5 = criteriaBuilder.equal(root.get("accountNonExpired"), pageBean.getCondition().isAccountNonExpired());
                predicate.getExpressions().add(predicate5);

                return predicate;
            }
        };
        Pageable pageable = PageRequest.of(pageBean.getPageNo(), pageBean.getPageSize(), Sort.by(Sort.Direction.ASC, "id"));
        Page<User> page = userDao.findAll(specification, pageable);
        return page;
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
        BeanUtils.copyProperties(user, userOld, "id", "roles");
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
