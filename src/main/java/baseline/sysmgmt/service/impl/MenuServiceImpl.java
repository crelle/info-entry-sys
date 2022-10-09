package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.model.entity.Menu;
import baseline.sysmgmt.mapper.MenuMapper;
import baseline.sysmgmt.service.MenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    public Menu create(Menu object) {
        return null;
    }

    @Override
    public Menu queryById(Long id) {
        return null;
    }

    @Override
    public List<Menu> queryAll() {
        return null;
    }

    @Override
    public int update(Long id, Menu object) {
        return 0;
    }

    @Override
    public void deleteById(Long id) {

    }
}
