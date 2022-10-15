package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.model.entity.RoleMenu;
import baseline.sysmgmt.mapper.RoleMenuMapper;
import baseline.sysmgmt.service.RoleMenuService;
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
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
    @Override
    public boolean create(RoleMenu object) {
        return save(object);
    }

    @Override
    public RoleMenu queryById(String id) {
        return getById(id);
    }

    @Override
    public List<RoleMenu> queryAll() {
        return list();
    }

    @Override
    public boolean update(RoleMenu object) {
        return updateById(object);
    }

    @Override
    public void deleteById(String id) {
        removeById(id);
    }

    @Override
    public Page<RoleMenu> pageByCondition(Page<RoleMenu> page) {
        return page(page);
    }
}
