package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.model.entity.RoleMenu;
import baseline.sysmgmt.mapper.RoleMenuMapper;
import baseline.sysmgmt.service.RoleMenuService;
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
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
    @Override
    public boolean create(RoleMenu object) {
        return save(object);
    }

    @Override
    public RoleMenu queryById(Long id) {
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
    public void deleteById(Long id) {
        removeById(id);
    }

    @Override
    public IPage<RoleMenu> pageByCondition(IPage<RoleMenu> page) {
        return page(page);
    }

    @Override
    public IPage<RoleMenu> pageByCondition(IPage<RoleMenu> page, Wrapper<RoleMenu> queryWrapper) {
        return page(page, queryWrapper);
    }
}
