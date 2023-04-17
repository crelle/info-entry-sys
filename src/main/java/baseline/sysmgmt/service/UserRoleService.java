package baseline.sysmgmt.service;

import baseline.sysmgmt.pojo.entity.Role;
import baseline.sysmgmt.pojo.query.UserRoleQuery;
import baseline.sysmgmt.pojo.vo.UserRoleVo;
import baseline.sysmgmt.pojo.vo.UserVo;
import baseline.sysmgmt.service.impl.BaseService;
import baseline.sysmgmt.pojo.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
public interface UserRoleService extends IService<UserRole>, BaseService<UserRoleVo,UserRole, UserRoleQuery> {

    int deleteByUserId(@Param("userId") String userId);

    boolean addSelective(List<UserRole> userRole);
}
