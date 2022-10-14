package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.mapper.UserMapper;
import baseline.sysmgmt.model.entity.User;
import baseline.sysmgmt.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean create(User object) {
        return save(object);
    }

    @Override
    public User queryById(Long id) {
        return getById(id);
    }

    @Override
    public List<User> queryAll() {
        return list();
    }

    @Override
    public boolean update(User object) {
        return updateById(object);
    }

    @Override
    public void deleteById(Long id) {
        removeById(id);
    }

    @Override
    public IPage<User> pageByCondition(IPage<User> page) {
        return page(page);
    }

    @Override
    public IPage<User> pageByCondition(IPage<User> page, Wrapper<User> queryWrapper) {
        return page(page, queryWrapper);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        QueryWrapper<User> queryWrapper = Wrappers.<User>query().eq("username", userName);
        User result = getOne(queryWrapper);
        if (result == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return result;
    }
}
