package baseline.app.service;

import baseline.app.pojo.entity.Department;
import baseline.app.pojo.query.DepartmentQuery;
import baseline.app.pojo.vo.DepartmentVo;
import baseline.common.baseBean.BaseService;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author crelle
 * @since 2022-11-09 10:06:28
 */
public interface DepartmentService extends IService<Department>, BaseService<DepartmentVo,Department, DepartmentQuery> {
    /**
     * 查询上级部门
     *
     * @return
     */
    List<Department> queryDepartmentUp();
}
