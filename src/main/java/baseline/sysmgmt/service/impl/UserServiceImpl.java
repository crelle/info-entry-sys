package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.mapper.UserMapper;
import baseline.sysmgmt.model.entity.User;
import baseline.sysmgmt.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public User create(User object) {
        return null;
    }

    @Override
    public User queryById(Long id) {
        return null;
    }

    @Override
    public List<User> queryAll() {
        return null;
    }

    @Override
    public int update(Long id, User object) {
        return 0;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = new User();
        user.setUsername(userName);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        User result = getOne(queryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return result;
    }
}
