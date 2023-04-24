package baseline.app.controller;


import baseline.app.pojo.entity.Department;
import baseline.app.pojo.entity.Project;
import baseline.app.pojo.query.DepartmentQuery;
import baseline.app.pojo.vo.DepartmentVo;
import baseline.app.service.DepartmentService;
import baseline.app.service.ProjectService;
import baseline.common.annotation.EnablePagination;
import baseline.common.baseBean.BaseController;
import baseline.common.pojo.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author crelle
 * @since 2022-11-09 10:06:28
 */
@Api(tags = "部门服务")
@RestController
@RequestMapping("/app/department")
public class DepartmentController implements BaseController<DepartmentVo, Department, DepartmentQuery> {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ProjectService projectService;

    @ApiOperation(value = "创建")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Department> create(@Validated(Department.POST.class) Department object) {
        ResponseResult result = new ResponseResult();
        boolean isSuccess = departmentService.create(object);
        if (!isSuccess) {
            result.buildFail("创建失败！");
        }
        return result;
    }

    @ApiOperation(value = "批量创建")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/creates", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Department> creates(@Validated(Department.POST.class) List<Department> objects) {
        ResponseResult result = new ResponseResult();
        boolean isSuccess = departmentService.create(objects);
        if (!isSuccess) {
            result.buildFail("批量创建失败！");
        }
        return result;
    }

    @ApiOperation(value = "根据ID删除")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> deleteById(@NotBlank String id) {
        ResponseResult result = new ResponseResult();
        List<Project> projectList = projectService
                .list()
                .stream().filter(project -> project.getDepartmentId().equals(id))
                .collect(Collectors.toList());
        if (!projectList.isEmpty()) {
            result.buildFail("有项目在使用此部门，无法删除！");
            return result;
        }
        departmentService.deleteById(id);
        return result;
    }

    @ApiOperation(value = "根据ID批量删除")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/deleteByIds", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> deleteByIds(List<String> ids) {
        ResponseResult result = new ResponseResult();
        departmentService.deleteByIds(ids);
        return result;
    }

    @ApiOperation(value = "根据ID更新")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/updateById", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> updateById(@Validated(Department.PUT.class) Department object) {
        ResponseResult result = new ResponseResult();
        boolean isSuccess = departmentService.update(object);
        if (!isSuccess) {
            result.buildFail("更新失败！");
        }
        return result;
    }

    @ApiOperation(value = "分页查询")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/pageByCondition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<Department>> page(Page<Department> pageBean) {
        ResponseResult result = new ResponseResult();
        result.setData(departmentService.pageByCondition(pageBean));
        return result;
    }

    @ApiOperation(value = "查询上级部门")
    @RequestMapping(value = "/queryDepartmentUp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Project> queryDepartmentUp() {
        ResponseResult result = new ResponseResult();
        result.setData(departmentService.queryDepartmentUp());
        return result;
    }

    @ApiOperation(value = "手动分页查询")
    @RequestMapping(value = "/manualPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @EnablePagination
    @Override
    public ResponseResult<Page<DepartmentVo>> manualPage(Page<DepartmentQuery> pageBean) {
        ResponseResult responseResult = new ResponseResult();
        Page<DepartmentVo> page = departmentService.manualPage(pageBean);
        responseResult.setData(page);
        return responseResult;
    }
}
