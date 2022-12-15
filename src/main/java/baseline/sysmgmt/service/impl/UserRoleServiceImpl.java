package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.pojo.entity.Role;
import baseline.sysmgmt.pojo.entity.UserRole;
import baseline.sysmgmt.mapper.UserRoleMapper;
import baseline.sysmgmt.service.UserRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
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

    @Autowired
    private UserRoleMapper userRoleMapper;

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
    public Page<UserRole> pageByCondition(Page<UserRole> page) {
        return page(page);
    }

    @Override
    public int deleteByUserId(String userId) {
        return userRoleMapper.deleteByUserId(userId);
    }

    @Override
    public boolean addSelective(List<UserRole> userRoles) {
        if (!CollectionUtils.isEmpty(userRoles)) {
            userRoles.forEach(userRole -> {
                save(userRole);
            });
        }
        return true;
    }
}
