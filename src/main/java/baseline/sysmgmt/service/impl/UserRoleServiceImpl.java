package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.model.entity.UserRole;
import baseline.sysmgmt.mapper.UserRoleMapper;
import baseline.sysmgmt.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    public UserRole create(UserRole object) {
        return null;
    }

    @Override
    public UserRole queryById(Long id) {
        return null;
    }

    @Override
    public List<UserRole> queryAll() {
        return null;
    }

    @Override
    public int update(Long id, UserRole object) {
        return 0;
    }

    @Override
    public void deleteById(Long id) {

    }
}
