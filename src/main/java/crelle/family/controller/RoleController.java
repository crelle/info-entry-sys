package crelle.family.controller;

import crelle.family.model.PageBean;
import crelle.family.model.ao.RoleAO;
import crelle.family.model.entity.User;
import crelle.family.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import crelle.family.common.ResponseResult;
import crelle.family.dao.RoleDao;
import crelle.family.model.entity.Role;

import java.util.List;
import java.util.Optional;

/**
 * @author:crelle
 * @className:RoleController
 * @version:1.0.0
 * @date:2021/3/23
 * @description:XX
 **/
@Api(tags = "角色服务")
@RestController
@RequestMapping(value = "/role")
public class RoleController implements BaseController<Role, RoleAO>{

    @Autowired
    private RoleService roleService;




    @ApiOperation(value = "创建角色")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Role> create(@RequestBody Role role) {
        ResponseResult<Role> responseResult = new ResponseResult<>();
        try {
            Role newRole = roleService.create(role);
            responseResult.setData(newRole);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据角色标识查询角色")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Role> queryById(@PathVariable Long id) {
        ResponseResult<Role> responseResult = new ResponseResult<>();
        try {
            Role role = roleService.queryById(id);
            responseResult.setData(role);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @Override
    public ResponseResult<Page<Role>> pageByCondition(PageBean<RoleAO> pageBean) {
        return null;
    }

    @ApiOperation(value = "查询所有角色")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<List<Role>> queryAll() {
        ResponseResult<List<Role>> responseResult = new ResponseResult<>();
        try {
            List<Role> roles = roleService.queryAll();
            responseResult.setData(roles);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据角色标识更新角色")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> updateById(@PathVariable Long id,@RequestBody Role role) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            int result = roleService.update(id, role);
            if (0 == result) {
                responseResult.buildFail("没有此角色，无法更新！");
            }
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据角色标识删除角色")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> deleteById(@RequestBody Long id) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            roleService.deleteById(id);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }


}
