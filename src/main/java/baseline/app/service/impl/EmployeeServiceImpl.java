package baseline.app.service.impl;

import baseline.app.pojo.entity.Employee;
import baseline.app.mapper.EmployeeMapper;
import baseline.app.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    @Override
    public boolean create(Employee object) {
        return save(object);
    }

    @Override
    public boolean create(List<Employee> objects) {
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
    public boolean update(Employee object) {
        return updateById(object);
    }

    @Override
    public Page<Employee> pageByCondition(Page<Employee> page) {


    }

    
    @Override
    public Employee queryById(String id) {
        return getById(id);
    }

    @Override
    public List<Employee> queryByIds(List<String> ids) {
        return null;
    }
}
