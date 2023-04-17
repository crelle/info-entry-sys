package baseline.sysmgmt.service.impl;

import baseline.common.pojo.vo.ResponseResult;
import baseline.sysmgmt.pojo.entity.Role;
import baseline.sysmgmt.pojo.entity.UserRole;
import baseline.sysmgmt.mapper.UserRoleMapper;
import baseline.sysmgmt.pojo.query.UserRoleQuery;
import baseline.sysmgmt.pojo.vo.UserRoleVo;
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
    public boolean deleteById(String id) {
        return removeById(id);
    }

    @Override
    public Page<UserRole> page(Page<UserRole> page) {
        return super.page(page);
    }

    @Override
    public Page<UserRoleVo> manualPage(Page<UserRoleQuery> pageBean) {
        return null;
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
