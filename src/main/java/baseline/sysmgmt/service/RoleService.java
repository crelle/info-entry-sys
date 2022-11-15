package baseline.sysmgmt.service;

import baseline.sysmgmt.model.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
public interface RoleService extends IService<Role>, BaseService<Role> {

    Role queryByName(String roleName);
}
