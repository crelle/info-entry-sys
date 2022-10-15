package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.model.entity.Role;
import baseline.sysmgmt.mapper.RoleMapper;
import baseline.sysmgmt.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
}
