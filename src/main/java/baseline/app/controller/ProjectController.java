package baseline.app.controller;


import baseline.app.pojo.entity.Project;
import baseline.app.service.ProjectService;
import baseline.common.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
 * @since 2022-11-09 10:06:28
 */
@Api(tags = "项目服务")
@RestController
@RequestMapping("/app/project")
public class ProjectController implements BaseController<Project> {
    @Autowired
    private ProjectService projectService;

    @ApiOperation(value = "创建")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Project> create(Project object) {
        return null;
    }

    @ApiOperation(value = "批量创建")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/creates", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Project> creates(List<Project> objects) {
        return null;
    }

    @ApiOperation(value = "根据ID删除")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> deleteById(String id) {
        return null;
    }

    @ApiOperation(value = "根据ID批量删除")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/deleteByIds", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> deleteByIds(List<String> ids) {
        return null;
    }

    @ApiOperation(value = "根据ID更新")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/updateById", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> updateById(Project object) {
        return null;
    }

    @ApiOperation(value = "分页查询")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/pageByCondition", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<Project>> pageByCondition(Page<Project> pageBean) {
        return null;
    }
}
