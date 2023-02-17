package baseline.app.service.impl;

import baseline.app.pojo.entity.Employee;
import baseline.app.mapper.EmployeeMapper;
import baseline.app.pojo.query.EmployeeQuery;
import baseline.app.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public boolean create(Employee object) {
        // 工号唯一
        List<Employee> employees = queryByEmpId(object.getJobNo());
        if (!employees.isEmpty()) {
            return false;
        }
        return save(object);
    }

    @Override
    public boolean create(List<Employee> objects) {
        return saveBatch(objects);
    }

    public void deleteById(String id) {
        removeById(id);
    }

    public void deleteByIds(List<String> ids) {
        removeByIds(ids);
    }

    @Override
    public boolean update(Employee object) {
        // 工号唯一
        List<Employee> employees = queryByEmpId(object.getJobNo());
        if (!object.getJobNo().equals(employees.get(0).getJobNo())) {
            return false;
        }
        return updateById(object);
    }

    @Override
    public Page<Employee> pageByCondition(Page<Employee> page) {
        Employee employee = page.getRecords().get(0);
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(employee.getName()), Employee::getName, employee.getName())
                .like(StringUtils.isNotBlank(employee.getSkill()), Employee::getSkill, employee.getSkill());
        return page(page, lambdaQueryWrapper);
    }

    @Override
    public Page<Employee> manualPage(Page<EmployeeQuery> pageBean) {
        return null;
    }

    @Override
    public Employee queryById(String id) {
        return null;
    }

    public Page<EmployeeQuery> queryByCondition(@RequestBody Page<EmployeeQuery> pageBean) {
        EmployeeQuery employeeQuery = pageBean.getRecords().get(0);
        Page<EmployeeQuery> employeeQueryPage = new Page<>();
        return employeeMapper.queryByCondition(employeeQueryPage, employeeQuery);
    }

    public List<Employee> queryByEmpId(String id) {
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.select().eq("job_no", id);
        return employeeMapper.selectList(wrapper);
    }

    public List<Employee> queryByIds(List<String> ids) {
        return null;
    }
}
