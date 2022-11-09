package baseline.app.service.impl;

import baseline.app.model.entity.Department;
import baseline.app.mapper.DepartmentMapper;
import baseline.app.service.DepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
    @Override
    public boolean create(Department object) {
        return save(object);
    }

    @Override
    public boolean create(List<Department> objects) {
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
    public boolean update(Department object) {
        return updateById(object);
    }

    @Override
    public Page<Department> pageByCondition(Page<Department> page) {
        return page(page);
    }

    @Override
    public Department queryById(String id) {
        return getById(id);
    }

    @Override
    public List<Department> queryByIds(List<String> ids) {
        return null;
    }
}
