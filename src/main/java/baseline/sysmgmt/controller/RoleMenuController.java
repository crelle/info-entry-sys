package baseline.sysmgmt.controller;


import baseline.common.enumeration.ResponseEnum;
import baseline.common.exception.BusinessException;
import baseline.common.pojo.vo.ResponseResult;
import baseline.sysmgmt.pojo.entity.Menu;
import baseline.sysmgmt.pojo.entity.Role;
import baseline.sysmgmt.service.RoleMenuService;
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
    public ResponseResult<List<Menu>> queryMenu(@RequestBody Role role) {
        return roleMenuService.queryMenu(role);
    }

    @ApiOperation(value = "编辑角色对应的菜单")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/updateMenu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> updateRoleMenu(@RequestBody Role roles) {
        try {
            roleMenuService.updateRoleMenu(roles);
        } catch (Exception e) {
            throw  e;
        }
        return ResponseResult.ok();

    }
}
