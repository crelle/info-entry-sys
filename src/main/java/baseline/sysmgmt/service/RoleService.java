package baseline.sysmgmt.service;

import baseline.sysmgmt.pojo.query.RoleQuery;
import baseline.sysmgmt.pojo.vo.RoleVo;
import baseline.sysmgmt.service.impl.BaseService;
import baseline.sysmgmt.pojo.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
public interface RoleService extends IService<Role>, BaseService<RoleVo,Role, RoleQuery> {

    List<Role> queryByNameZh(String roleNameZh);

    List<Role> queryByName(String roleName);

    boolean create(Role role);

    boolean deleteById(String id);
}