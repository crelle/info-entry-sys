package baseline.app.controller;


import baseline.app.pojo.entity.Customer;
import baseline.app.pojo.entity.Project;
import baseline.app.pojo.entity.Region;
import baseline.app.pojo.query.RegionQuery;
import baseline.app.pojo.vo.RegionVo;
import baseline.app.service.CustomerService;
import baseline.app.service.ProjectService;
import baseline.app.service.RegionService;
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
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author crelle
 * @since 2022-11-09 10:06:28
 */
@Api(tags = "区域服务")
@RestController
@RequestMapping("/app/region")
public class RegionController implements BaseController<RegionVo, Region, RegionQuery> {
    @Autowired
    private RegionService regionService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProjectService projectService;

    @ApiOperation(value = "创建")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Region> create(@Validated(Region.POST.class) Region object) {
        ResponseResult<Region> regionResponseResult = new ResponseResult<>();
        boolean isSuccess = regionService.create(object);
        if (!isSuccess) {
            regionResponseResult.buildFail("更新失败！");
        }
        return regionResponseResult;
    }

    @ApiOperation(value = "批量创建")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/creates", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Region> creates(@Validated(Region.POST.class) List<Region> objects) {
        ResponseResult result = new ResponseResult();
        boolean isSuccess = regionService.create(objects);
        if (!isSuccess) {
            result.buildFail("更新失败");
        }
        return result;
    }

    @ApiOperation(value = "根据ID删除")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> deleteById(@NotBlank String id) {
        ResponseResult result = new ResponseResult();
        //客户 项目  是否绑定地域
        List<Customer> customerList = customerService
                .list()
                .stream()
                .filter(Objects::nonNull)
                .filter(customer -> customer.getRegionId().equals(id))
                .collect(Collectors.toList());

        if (!customerList.isEmpty()) {
            result.buildFail("有客户在使用此地域，无法删除！");
            return result;
        }
        List<Project> projectList = projectService
                .list()
                .stream()
                .filter(project -> project.getRegionId().equals(id))
                .collect(Collectors.toList());
        if (!projectList.isEmpty()) {
            result.buildFail("有项目在使用此地域，无法删除！");
            return result;
        }

        regionService.deleteById(id);
        return result;
    }

    @ApiOperation(value = "根据ID批量删除")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/deleteByIds", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> deleteByIds(List<String> ids) {
        ResponseResult result = new ResponseResult();
        regionService.deleteByIds(ids);
        return result;
    }

    @ApiOperation(value = "根据ID更新")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/updateById", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> updateById(@Validated(Region.PUT.class) Region object) {
        ResponseResult result = new ResponseResult();
        boolean isSuccess = regionService.update(object);
        if (!isSuccess) {
            result.buildFail("更新失败");
        }
        return result;
    }

    @ApiOperation(value = "分页查询")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/pageByCondition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<Region>> page(Page<Region> region) {
        ResponseResult result = new ResponseResult();
        result.setData(regionService.pageByCondition(region));
        return result;
    }

    @Override
    public ResponseResult<Page<RegionVo>> manualPage(Page<RegionQuery> pageBean) {
        return null;
    }
}
