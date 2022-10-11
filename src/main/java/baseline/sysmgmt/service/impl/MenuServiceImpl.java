package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.model.entity.Menu;
import baseline.sysmgmt.mapper.MenuMapper;
import baseline.sysmgmt.service.MenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    public boolean create(Menu object) {
        return save(object);
    }

    @Override
    public Menu queryById(Long id) {
        return getById(id);
    }

    @Override
    public List<Menu> queryAll() {
        return list();
    }

    @Override
    public boolean update(Menu object) {
        return updateById(object);
    }

    @Override
    public void deleteById(Long id) {
        removeById(id);
    }

    @Override
    public IPage<Menu> pageByCondition(IPage<Menu> page) {
        return page(page);
    }

    @Override
    public IPage<Menu> pageByCondition(IPage<Menu> page, Wrapper<Menu> queryWrapper) {
        return page(page, queryWrapper);
    }
}
