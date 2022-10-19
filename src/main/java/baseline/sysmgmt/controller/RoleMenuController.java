package baseline.sysmgmt.controller;


import baseline.sysmgmt.common.ResponseResult;
import baseline.sysmgmt.model.entity.Menu;
import baseline.sysmgmt.model.entity.Role;
import baseline.sysmgmt.service.RoleMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
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
 * @since 2022-10-01 12:06:26
 */
@Api(tags = "角色菜单管理")
@RestController
@RequestMapping("/sysmgmt/role-menu")
public class RoleMenuController {
    @Autowired
    private RoleMenuService roleMenuService;

    @ApiOperation(value = "查询角色对应的菜单")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/queryMenu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Role> queryMenu(@RequestBody Role role) {
        return roleMenuService.queryMenu(role);
    }

    @ApiOperation(value = "编辑角色对应的菜单")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/updateMenu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> updateRoleMenu(@RequestBody List<Role> roles) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            roleMenuService.updateRoleMenu(roles);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;

    }
}
