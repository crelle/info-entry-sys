package baseline.app.controller;


import baseline.app.pojo.entity.Asset;
import baseline.app.pojo.query.AssetQuery;
import baseline.app.pojo.vo.AssetVo;
import baseline.app.service.AssetService;
import baseline.common.baseBean.BaseController;
import baseline.common.pojo.vo.ResponseResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javafx.print.PageOrientation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * <p>
 * 资产表 前端控制器
 * </p>
 *
 * @author crelle
 * @since 2023-02-28 05:09:23
 */
@RestController
@RequestMapping("/app/asset")
@Api(tags = "资产管理")
public class AssetController implements BaseController<AssetVo, Asset, AssetQuery> {
    @Autowired
    private AssetService assetService;

    @ApiOperation(value = "创建")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Asset> create(@RequestBody @Validated(Asset.POST.class) Asset object) {
        ResponseResult result = new ResponseResult();
        boolean isSuccess = assetService.create(object);
        if (!isSuccess) {
            result.buildFail("创建失败！");
        }
        return result;
    }

    @ApiOperation(value = "批量创建")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/creates", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Asset> creates(@Validated(Asset.POST.class) List<Asset> objects) {
        ResponseResult result = new ResponseResult();
        boolean isSuccess = assetService.create(objects);
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
        assetService.deleteById(id);
        return result;
    }

    @ApiOperation(value = "根据ID批量删除")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/deleteByIds", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> deleteByIds(List<String> ids) {
        ResponseResult result = new ResponseResult();
        assetService.deleteByIds(ids);
        return result;
    }

    @ApiOperation(value = "根据ID更新")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/updateById", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> updateById(@Validated(Asset.PUT.class) Asset object) {
        return null;
    }

    @ApiOperation(value = "分页查询")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/pageByCondition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<Asset>> page(Page<Asset> pageBean) {
        ResponseResult result = new ResponseResult();
        result.setData(assetService.pageByCondition(pageBean));
        return result;
    }

    @ApiOperation(value = "手动分页查询")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/manualPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<AssetVo>> manualPage(Page<AssetQuery> pageBean) {
        return null;
    }

    @ApiOperation(value = "根据员工id查询资产信息")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/pageByEmployeeId", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<List<Asset>> page(String employeeId) {
        ResponseResult result = new ResponseResult();
        result.setData(assetService.queryByEmployeeId(employeeId));
        return result;
    }
}
