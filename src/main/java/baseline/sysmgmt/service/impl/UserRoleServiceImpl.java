package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.model.entity.UserRole;
import baseline.sysmgmt.mapper.UserRoleMapper;
import baseline.sysmgmt.service.UserRoleService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    public boolean create(UserRole object) {
        return save(object);
    }

    @Override
    public UserRole queryById(String id) {
        return getById(id);
    }

    @Override
    public List<UserRole> queryAll() {
        return list();
    }

    @Override
    public boolean update(UserRole object) {
        return updateById(object);
    }

    @Override
    public void deleteById(String id) {
        removeById(id);
    }

    @Override
    public IPage<UserRole> pageByCondition(IPage<UserRole> page) {
        return page(page);
    }

    @Override
    public IPage<UserRole> pageByCondition(IPage<UserRole> page, Wrapper<UserRole> queryWrapper) {
        return page(page, queryWrapper);
    }
}
