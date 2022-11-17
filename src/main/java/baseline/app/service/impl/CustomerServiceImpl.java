package baseline.app.service.impl;

import baseline.app.pojo.entity.Customer;
import baseline.app.mapper.CustomerMapper;
import baseline.app.service.CustomerService;
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
 * @since 2022-11-09 10:06:28
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Override
    public boolean create(Customer object) {
        return save(object);
    }

    @Override
    public boolean create(List<Customer> objects) {
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
    public boolean update(Customer object) {
        return updateById(object);
    }

    @Override
    public Page<Customer> pageByCondition(Page<Customer> page) {
        return page(page);
    }

    @Override
    public Customer queryById(String id) {
        return getById(id);
    }

    @Override
    public List<Customer> queryByIds(List<String> ids) {
        return null;
    }
}
