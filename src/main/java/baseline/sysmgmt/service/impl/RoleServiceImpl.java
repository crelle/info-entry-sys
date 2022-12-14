package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.pojo.entity.Role;
import baseline.sysmgmt.mapper.RoleMapper;
import baseline.sysmgmt.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public void deleteById(String id) {
        removeById(id);
    }

    @Override
    public Page<Role> pageByCondition(Page<Role> page) {
        return page(page);
    }

    @Override
    public Role queryByNameAndNameZh(String roleName,String roleNameZh) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("name", roleName).eq("name_zh",roleNameZh);
        return getOne(queryWrapper);
    }
}
