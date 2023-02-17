package baseline.app.mapper;

import baseline.app.pojo.entity.Employee;
import baseline.app.pojo.query.EmployeeQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author crelle
 * @since 2022-11-24 10:45:04
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    Page<EmployeeQuery> queryByCondition(Page<EmployeeQuery> page, @Param("param") EmployeeQuery employeeQuery);

}
