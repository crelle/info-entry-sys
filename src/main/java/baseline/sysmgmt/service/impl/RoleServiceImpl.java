package baseline.sysmgmt.service.impl;

import baseline.common.pojo.vo.ResponseResult;
import baseline.sysmgmt.pojo.entity.Role;
import baseline.sysmgmt.mapper.RoleMapper;
import baseline.sysmgmt.pojo.query.RoleQuery;
import baseline.sysmgmt.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    public boolean create(Role object) {
        return save(object);
    }

    @Override
    public Role queryById(String id) {
        return getById(id);
    }

    @Override
    public List<Role> queryAll() {
        return list();
    }

    @Override
    public boolean update(Role object) {
        return updateById(object);
    }

    @Override
    public boolean deleteById(String id) {
        return removeById(id);
    }

    @Override
    public Page<Role> page(Page<Role> page) {
        LambdaQueryWrapper<Role> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (!CollectionUtils.isEmpty(page.getRecords())) {
            Role role = page.getRecords().get(0);
            lambdaQueryWrapper.like(StringUtils.isNotBlank(role.getNameZh()), Role::getNameZh, role.getNameZh());
        }
        return super.page(page, lambdaQueryWrapper);
    }

    @Override
    public Page<Role> manualPage(Page<RoleQuery> pageBean) {
        return null;
    }

    @Override
    public List<Role> queryByNameZh(String roleNameZh) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("name_zh", roleNameZh);
        return list(queryWrapper);
    }

    @Override
    public List<Role> queryByName(String roleName) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("name", roleName);
        return list(queryWrapper);
    }
}
