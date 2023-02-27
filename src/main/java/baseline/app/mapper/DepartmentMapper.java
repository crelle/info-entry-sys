package baseline.app.mapper;

import baseline.app.pojo.entity.Department;
import baseline.app.pojo.query.DepartmentQuery;
import baseline.app.pojo.vo.DepartmentVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author crelle
 * @since 2022-11-09 10:06:28
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

    Page<DepartmentVo> manualPage(@Param("page") Page<Department> page, @Param("param") DepartmentQuery departmentQuery);


}
