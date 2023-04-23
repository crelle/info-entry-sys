package baseline.app.mapper;

import baseline.app.pojo.entity.Department;
import baseline.app.pojo.query.DepartmentQuery;
import baseline.app.pojo.vo.DepartmentVo;
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
 * @since 2022-11-09 10:06:28
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

    List<DepartmentVo> manualPage(@Param("param") DepartmentQuery departmentQuery);


}
