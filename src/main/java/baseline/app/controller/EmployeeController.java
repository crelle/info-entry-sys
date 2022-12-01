package baseline.app.controller;


import baseline.app.pojo.entity.Employee;
import baseline.app.service.EmployeeService;
import baseline.common.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class EmployeeController implements BaseController<Employee> {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation("创建")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Employee> create(Employee object) {
        ResponseResult result = new ResponseResult();
        employeeService.create(object);
        return result;
    }

    @ApiOperation("批量创建")
    @RequestMapping(value = "/creates", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Employee> creates(List<Employee> objects) {
        ResponseResult result = new ResponseResult();
        employeeService.create(objects);
        return result;
    }

    @ApiOperation("删除")
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> deleteById(String id) {
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
    public ResponseResult<String> updateById(Employee object) {
        ResponseResult result = new ResponseResult();
        employeeService.updateById(object);
        return result;
    }

    @ApiOperation("分页查询")
    @RequestMapping(value = "/pageByCondition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<Employee>> pageByCondition(Page<Employee> pageBean) {
        ResponseResult result = new ResponseResult();
        employeeService.pageByCondition(pageBean);
        return result;
    }
}
