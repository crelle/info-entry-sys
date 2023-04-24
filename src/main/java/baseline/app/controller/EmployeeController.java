package baseline.app.controller;


import baseline.app.pojo.entity.Employee;
import baseline.app.pojo.query.EmployeeQuery;
import baseline.app.pojo.vo.EmployeeVo;
import baseline.app.service.EmployeeService;
import baseline.common.baseBean.BaseController;
import baseline.common.exception.BusinessException;
import baseline.common.pojo.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author crelle
 * @since 2022-11-24 10:45:04
 */
@Api(tags = "员工服务")
@RestController
@RequestMapping("/app/employee")
public class EmployeeController implements BaseController<EmployeeVo, Employee, EmployeeQuery> {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation("创建")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Employee> create(@Validated(Employee.POST.class) Employee object) {
        ResponseResult result = new ResponseResult();
        boolean isSuccess = employeeService.create(object);
        if (!isSuccess) {
            result.buildFail("创建失败！");
        }
        return result;
    }

    @ApiOperation("批量创建")
    @RequestMapping(value = "/creates", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Employee> creates(@Validated(Employee.POST.class) List<Employee> objects) {
        ResponseResult result = new ResponseResult();
        employeeService.create(objects);
        return result;
    }

    @ApiOperation("删除")
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> deleteById(@NotBlank String id) {
        ResponseResult result = new ResponseResult();
        employeeService.deleteById(id);
        return result;
    }

    @ApiOperation("批量删除")
    @RequestMapping(value = "/deleteByIds", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> deleteByIds(List<String> ids) {
        ResponseResult result = new ResponseResult();
        employeeService.deleteByIds(ids);
        return result;
    }

    @ApiOperation("更新")
    @RequestMapping(value = "/updateById", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> updateById(@Validated(Employee.PUT.class) Employee object) {
        ResponseResult result = new ResponseResult();
        boolean isSuccess = employeeService.update(object);
        if (!isSuccess) {
            result.buildFail("更新失败！");
        }
        return result;
    }

    @ApiOperation("分页查询")
    @RequestMapping(value = "/pageByCondition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Page<Employee>> page(@RequestBody Page<Employee> pageBean) {
        ResponseResult result = new ResponseResult();
        result.setData(employeeService.pageByCondition(pageBean));
        return result;
    }

    @Override
    public ResponseResult<Page<EmployeeVo>> manualPage(Page<EmployeeQuery> pageBean) {
        return null;
    }

    @ApiOperation(value = "手动分页查询")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/manualPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Page<EmployeeQuery>> queryByCondition(@RequestBody Page<EmployeeQuery> pageBean) {
        ResponseResult result = new ResponseResult();
        result.setData(employeeService.queryByCondition(pageBean));
        return result;
    }

    @ApiOperation(value = "导入员工信息")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> importExcel(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        ResponseResult result = new ResponseResult();
        try {
            result.setData(employeeService.importEmployee(file));
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        return result;
    }

    @ApiOperation(value = "导出Excel")
    @GetMapping("/downloadExcel")
    public ResponseResult<String> downloadExcelExport(HttpServletRequest request, HttpServletResponse response, Employee param) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            result.setData(employeeService.purchaseOrderSubExport(request, response, param));
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        return result;
    }

    @ApiOperation(value = "导出Excel模板")
    @GetMapping("/downloadTemplate")
    public ResponseResult<String> downloadTemplateExport(HttpServletRequest request, HttpServletResponse response, Employee param) throws Exception {
        ResponseResult result = new ResponseResult();
        try {
            result.setData(employeeService.downloadTemplate(request, response, param));
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        return result;
    }
}
