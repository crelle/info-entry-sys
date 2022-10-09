package baseline.sysmgmt.service.impl;

import baseline.sysmgmt.model.entity.Role;
import baseline.sysmgmt.mapper.RoleMapper;
import baseline.sysmgmt.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Override
    public Role create(Role object) {
        return null;
    }

    @Override
    public Role queryById(Long id) {
        return null;
    }

    @Override
    public List<Role> queryAll() {
        return null;
    }

    @Override
    public int update(Long id, Role object) {
        return 0;
    }

    @Override
    public void deleteById(Long id) {

    }
}
