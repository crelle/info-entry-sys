package baseline.app.service;

import baseline.app.pojo.entity.Employee;
import baseline.app.pojo.query.EmployeeQuery;
import baseline.common.baseBean.BaseService;
import baseline.common.pojo.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author crelle
 * @since 2022-11-24 10:45:04
 */
public interface EmployeeService extends IService<Employee>, BaseService<Employee, EmployeeQuery> {

    Page<EmployeeQuery> queryByCondition(Page<EmployeeQuery> pageBean);
}
