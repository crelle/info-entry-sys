package baseline.sysmgmt.service;

import baseline.sysmgmt.pojo.entity.Menu;
import baseline.sysmgmt.pojo.query.RoleMenuQuery;
import baseline.sysmgmt.pojo.vo.RoleMenuVo;
import baseline.sysmgmt.service.impl.BaseService;
import baseline.common.pojo.vo.ResponseResult;
import baseline.sysmgmt.pojo.entity.Role;
import baseline.sysmgmt.pojo.entity.RoleMenu;
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
public interface RoleMenuService extends IService<RoleMenu>, BaseService<RoleMenuVo,RoleMenu, RoleMenuQuery> {
    ResponseResult<List<Menu>> queryMenu(Role role);

    void updateRoleMenu(Role roles);

}
