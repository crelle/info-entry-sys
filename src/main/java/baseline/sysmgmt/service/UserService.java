package baseline.sysmgmt.service;

import baseline.sysmgmt.pojo.query.UserQuery;
import baseline.sysmgmt.pojo.vo.UserVo;
import baseline.sysmgmt.service.impl.BaseService;
import baseline.sysmgmt.pojo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
public interface UserService extends UserDetailsService, IService<User>, BaseService<UserVo,User, UserQuery> {
    int updatePasswordById(String password,User user);

    int resetPassword(String userId);
}
