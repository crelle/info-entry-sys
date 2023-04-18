package baseline.app.service;

import baseline.app.pojo.entity.Employee;
import baseline.app.pojo.query.EmployeeQuery;
import baseline.app.pojo.vo.EmployeeVo;
import baseline.common.baseBean.BaseService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author crelle
 * @since 2022-11-24 10:45:04
 */
public interface EmployeeService extends IService<Employee>, BaseService<EmployeeVo, Employee, EmployeeQuery> {

    Page<EmployeeQuery> queryByCondition(Page<EmployeeQuery> pageBean);

    String importEmployee(MultipartFile file) throws IOException;

    /**
     * 导出Excel
     *
     * @param request
     * @param response
     * @param param
     */
    String purchaseOrderSubExport(HttpServletRequest request, HttpServletResponse response, Employee param) throws Exception;

    String downloadTemplate(HttpServletRequest request, HttpServletResponse response, Employee param) throws Exception;
}
