package baseline.sysmgmt.controller;


import baseline.common.pojo.vo.ResponseResult;
import baseline.sysmgmt.pojo.entity.Dictionary;
import baseline.sysmgmt.pojo.query.DictionaryQuery;
import baseline.sysmgmt.pojo.vo.DictionaryVo;
import baseline.sysmgmt.service.DictionaryService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author crelle
 * @since 2022-12-23 05:23:32
 */
@Api(tags = "字典管理")
@RestController
@RequestMapping("/sysmgmt/dictionary")
public class DictionaryController implements BaseController<DictionaryVo, Dictionary, DictionaryQuery> {
    @Autowired
    private DictionaryService dictionaryService;

    @ApiOperation(value = "创建")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Dictionary> create(@RequestBody @Validated(Dictionary.POST.class) Dictionary obj) {
        try {

            dictionaryService.create(obj);
        } catch (Exception e) {
            throw e;
        }
        return ResponseResult.ok();
    }

    @ApiOperation(value = "根据菜单标识查询菜单")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Dictionary> queryById(String id) {
        ResponseResult responseResult = ResponseResult.ok();
        try {
            responseResult.setData(dictionaryService.queryById(id));
        } catch (Exception e) {
            throw e;
        }
        return responseResult;
    }

    @ApiOperation(value = "分页查询", hidden = true)
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/page", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<Dictionary>> page(Page<Dictionary> pageBean) {
        ResponseResult responseResult = ResponseResult.ok();
        try {
        } catch (Exception e) {
            throw e;
        }
        return ResponseResult.ok();
    }

    @ApiOperation(value = "手动分页查询")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/manualPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<DictionaryVo>> manualPage(Page<DictionaryQuery> pageBean) {
        ResponseResult responseResult = ResponseResult.ok();
        try {
            responseResult.setData(dictionaryService.manualPage(pageBean));
        } catch (Exception e) {
            throw e;
        }
        return responseResult;
    }

    @Override
    public ResponseResult<List<Dictionary>> queryAll() {
        ResponseResult responseResult = ResponseResult.ok();
        try {

        } catch (Exception e) {
            throw e;
        }
        return ResponseResult.ok();
    }

    @ApiOperation(value = "根据id更新字典", hidden = true)
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/updateById", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> updateById(String id, @Validated(Dictionary.PUT.class) Dictionary obj) {
        try {
            dictionaryService.updateById(obj);
        } catch (Exception e) {
            throw e;
        }
        return ResponseResult.ok();
    }

    @ApiOperation(value = "更新字典")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> update(@RequestBody @Validated(Dictionary.PUT.class) Dictionary obj) {
        try {
            dictionaryService.update(obj);
        } catch (Exception e) {
            throw e;
        }
        return ResponseResult.ok();
    }

    @ApiOperation(value = "删除字典")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> deleteById(@PathVariable(value = "id") @NotNull String id) {
        try {
            dictionaryService.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
        return ResponseResult.ok();
    }

    @ApiOperation(value = "根据父级ID查询子级菜单")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/queryByParentId/{parentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<DictionaryVo> queryByParentId(@PathVariable(value = "parentId") @NotNull String parentId) {
        ResponseResult responseResult = ResponseResult.ok();
        try {
            responseResult.setData(dictionaryService.queryByParentId(parentId));
        } catch (Exception e) {

            throw e;
        }
        return responseResult;
    }

    @ApiOperation(value = "根据父级名称精确查询菜单")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/queryByParentName/{parentName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<DictionaryVo> queryByParentName(@PathVariable(value = "parentName") @NotNull String parentName) {
        ResponseResult responseResult = ResponseResult.ok();
        try {
            responseResult.setData(dictionaryService.queryByParentName(parentName));
        } catch (Exception e) {
            throw e;
        }
        return responseResult;
    }
}
