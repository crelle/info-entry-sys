package baseline.sysmgmt.serviceImpl;

import baseline.sysmgmt.model.entity.User;
import baseline.sysmgmt.mapper.UserMapper;
import baseline.sysmgmt.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
