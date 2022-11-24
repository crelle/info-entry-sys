package baseline.app.service.impl;

import baseline.app.mapper.ContactPersonMapper;
import baseline.app.pojo.entity.ContactPerson;
import baseline.app.service.ContactPersonService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author crelle
 * @since 2022-11-24 10:45:04
 */
@Service
public class ContactPersonServiceImpl extends ServiceImpl<ContactPersonMapper, ContactPerson> implements ContactPersonService {
    @Override
    public boolean create(ContactPerson object) {
        return save(object);
    }

    @Override
    public boolean create(List<ContactPerson> objects) {
        return saveBatch(objects);
    }

    @Override
    public void deleteById(String id) {
        removeById(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        removeByIds(ids);
    }

    @Override
    public boolean update(ContactPerson object) {
        return updateById(object);
    }

    @Override
    public Page<ContactPerson> pageByCondition(Page<ContactPerson> page) {
        return page(page);
    }

    @Override
    public ContactPerson queryById(String id) {
        return getById(id);
    }

    @Override
    public List<ContactPerson> queryByIds(List<String> ids) {
        return null;
    }
}
