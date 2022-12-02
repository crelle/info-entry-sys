package baseline.sysmgmt.service;

import baseline.sysmgmt.pojo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
public interface UserService extends UserDetailsService, IService<User>, BaseService<User> {
    int updatePasswordById(String password,User user);
}
