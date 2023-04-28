package baseline.app.service.impl;

import baseline.app.pojo.entity.ContactPersonProject;
import baseline.app.mapper.ContactPersonProjectMapper;
import baseline.app.service.ContactPersonProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 接口人项目关系表 服务实现类
 * </p>
 *
 * @author crelle
 * @since 2023-04-28 11:46:31
 */
@Service
public class ContactPersonProjectServiceImpl extends ServiceImpl<ContactPersonProjectMapper, ContactPersonProject> implements ContactPersonProjectService {

}
