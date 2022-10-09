package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.model.entity.RoleMenu;
import baseline.sysmgmt.mapper.RoleMenuMapper;
import baseline.sysmgmt.service.RoleMenuService;
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
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
    @Override
    public RoleMenu create(RoleMenu object) {
        return null;
    }

    @Override
    public RoleMenu queryById(Long id) {
        return null;
    }

    @Override
    public List<RoleMenu> queryAll() {
        return null;
    }

    @Override
    public int update(Long id, RoleMenu object) {
        return 0;
    }

    @Override
    public void deleteById(Long id) {

    }
}
