package baseline.app.mapper;

import baseline.app.pojo.entity.Employee;
import baseline.app.pojo.query.EmployeeQuery;
import baseline.app.pojo.vo.EmployeeVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    List<EmployeeVo> queryByCondition(@Param("param") EmployeeQuery employeeQuery);

    List<Employee> queryByProjectId(@Param("projectId") String projectId);

    List<Employee> queryByPostId(@Param("postId") String postId);
}
