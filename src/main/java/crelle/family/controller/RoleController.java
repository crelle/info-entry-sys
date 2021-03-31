package crelle.family.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
public class RoleController {

    @Autowired
    private RoleDao roleDao;

    @ApiOperation(value = "查询所有角色")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/queryRoles", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<List<Role>> queryRoles() {
        ResponseResult<List<Role>> responseResult = new ResponseResult<>();
        try {
            List<Role> roles = roleDao.findAll();
            responseResult.setData(roles);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据角色标识查询角色")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/queryRoleById", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Optional<Role>> queryRoleById(@RequestBody Long id) {
        ResponseResult<Optional<Role>> responseResult = new ResponseResult<>();
        try {
            Optional<Role> roles = roleDao.findById(id);
            responseResult.setData(roles);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据角色标识删除角色")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/deleteRole", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<List<Role>> deleteRole(@RequestBody Long id) {
        ResponseResult<List<Role>> responseResult = new ResponseResult<>();
        try {
            roleDao.deleteById(id);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }


}
