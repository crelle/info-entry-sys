package crelle.family.controller;

import crelle.family.common.ResponseResult;
import crelle.family.model.PageBean;
import crelle.family.model.ao.RoleAO;
import crelle.family.model.entity.Menu;
import crelle.family.model.entity.Role;
import crelle.family.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
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
public class AuthorityController implements BaseController<Role, RoleAO> {

    private RoleService roleService;


    @Override
    public ResponseResult<Role> create(Role obj) {
        return null;
    }

    @ApiOperation(value = "根据角色标识查询菜单")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult queryById(Long id) {
        ResponseResult<Role> responseResult = new ResponseResult<Role>();
        try {
            Role role = roleService.queryById(id);
            responseResult.setData(role);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @Override
    public ResponseResult<List<Role>> queryAll() {
        return null;
    }

    @ApiOperation(value = "更新角色")
    @ApiParam(required = true, name = "id and obj", value = "入参")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> updateById(Long id, Role role) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            Role oldRole = roleService.queryById(id);
            if (null == oldRole) {
                responseResult.buildFail("要更新的角色不存在！");
                return responseResult;
            }
            BeanUtils.copyProperties(role, oldRole, "id", "users");
            int result = roleService.update(id, oldRole);
            if (0 == result) {
                responseResult.buildFail("更新失败！");
            }
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @Override
    public ResponseResult<String> deleteById(Long id) {
        return null;
    }

    @ApiOperation(value = "分页查询角色")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/page", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<Role>> pageByCondition(PageBean<RoleAO> pageBean) {
        ResponseResult<Page<Role>> responseResult = new ResponseResult<>();
        try {
            Page<Role> page = roleService.pageByCondition(pageBean);
            responseResult.setData(page);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }


}
