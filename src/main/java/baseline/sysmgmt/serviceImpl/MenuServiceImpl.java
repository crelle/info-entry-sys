package baseline.sysmgmt.serviceImpl;

import baseline.sysmgmt.model.entity.Menu;
import baseline.sysmgmt.mapper.MenuMapper;
import baseline.sysmgmt.service.MenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
