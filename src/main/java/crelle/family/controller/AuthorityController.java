package crelle.family.controller;

import crelle.family.common.ResponseResult;
import crelle.family.model.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:crelle
 * @className:AuthorityController
 * @version:1.0.0
 * @date:2021/4/14
 * @description:XX
 **/
@RestController
@RequestMapping(value = "/authority")
@Api(tags = "权限服务")
public class AuthorityController implements BaseController {


    @Override
    public ResponseResult create(Object obj) {
        return null;
    }

    @ApiOperation(value = "根据角色标识查询菜单")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/detail/{i}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult queryById(Long id) {
        return null;
    }

    @ApiOperation(value = "更新角色对应的菜单")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/page", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page> pageByCondition(PageBean pageBean) {
        return null;
    }

    @ApiOperation(value = "更新角色标识分页查询对应的菜单")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/page", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> updateById(Long id, Object obj) {
        return null;
    }

    @Override
    public ResponseResult<List> queryAll() {
        return null;
    }


    @Override
    public ResponseResult<String> deleteById(Long id) {
        return null;
    }
}
