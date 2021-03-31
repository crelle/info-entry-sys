package crelle.family.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import crelle.family.common.ResponseResult;
import crelle.family.model.entity.Menu;
import crelle.family.model.entity.Role;
import crelle.family.service.MenuService;

import java.util.List;

/**
 * @author:crelle
 * @className:MenuController
 * @version:1.0.0
 * @date:2021/3/23
 * @description:XX
 **/
@Api(tags = "菜单服务")
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "新增菜单")
    @ApiParam(required = true, name = "menu", value = "入参")
    @RequestMapping(value = "/addMenu", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Menu> addMenu(@RequestBody Menu menu) {
        ResponseResult<Menu> responseResult = new ResponseResult<>();
        try {
            if (checkAddMenuParams(menu, responseResult)) {
                return responseResult;
            }

            Menu menu1 = menuService.saveMenu(menu);
            responseResult.setData(menu1);

        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }


    @ApiOperation(value = "删除所有菜单")
    @ApiParam(required = true, name = "menu", value = "入参")
    @RequestMapping(value = "/deleteMenu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> deleteMenu() {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            menuService.deleteMenus();
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据菜单标识删除菜单")
    @ApiParam(required = true, name = "menu", value = "入参")
    @RequestMapping(value = "/deleteMenuById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> deleteMenuById(@RequestBody Long menuId) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            if (StringUtils.isNotBlank(String.valueOf(menuId))) {
                responseResult.buildFail("菜单标识位空！");
                return responseResult;
            }
            menuService.deleteMenuById(menuId);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "修改菜单")
    @ApiParam(required = true, name = "menu", value = "入参")
    @RequestMapping(value = "/updateMenu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Menu> updateMenu(@RequestBody Menu menu) {
        ResponseResult<Menu> responseResult = new ResponseResult<>();
        try {
            menuService.saveMenu(menu);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return null;
    }

    @ApiOperation(value = "查询所有菜单")
    @ApiParam(required = true, name = "menu", value = "入参")
    @RequestMapping(value = "/queryMenus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<List<Menu>> queryMenus() {
        ResponseResult<List<Menu>> responseResult = new ResponseResult<>();
        try {
            List<Menu> menuList = menuService.queryMenus();
            responseResult.setData(menuList);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据角色标识查询菜单")
    @ApiParam(required = true, name = "menu", value = "入参")
    @RequestMapping(value = "/queryMenusByRoleId", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<List<Menu>> queryMenusByRoleId() {
        ResponseResult<List<Menu>> responseResult = new ResponseResult<>();
        try {
            List<Menu> menuList = menuService.queryMenus();
            responseResult.setData(menuList);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    /**
     * @author:crelle
     * @date:2021/3/23
     * @title:checkAddMenuParams
     * @description:
     * @params:[menu, responseResult]
     * @return:boolean
     * @throw:
     */
    private boolean checkAddMenuParams(Menu menu, ResponseResult<Menu> responseResult) {
        if (!(null == menu.getId())) {
            responseResult.buildFail("菜单标识使用jpa自动生成，不需要传入！");
            return true;
        }
        if (StringUtils.isBlank(menu.getName())) {
            responseResult.buildFail("菜单名称为空！");
            return true;
        }
        if (StringUtils.isBlank(menu.getUrl())) {
            responseResult.buildFail("菜单对应的资源路径为空！");
            return true;
        }
        if (StringUtils.isBlank(menu.getPath())) {
            responseResult.buildFail("菜单对应的页面路径为空！");
            return true;
        }
        if (StringUtils.isBlank(menu.getComponent())) {
            responseResult.buildFail("菜单对应的页面组件为空！");
            return true;
        }
        if (CollectionUtils.isEmpty(menu.getRoles())) {
            responseResult.buildFail("菜单对应的角色为空！");
            return true;
        }
        if (!CollectionUtils.isEmpty(menu.getRoles())) {
            for (Role role : menu.getRoles()) {
                if (StringUtils.isNotBlank(String.valueOf(role.getId()))) {
                    responseResult.buildFail("角色标识使用jpa自动生成，不需要传入！");
                    return true;
                }
            }
        }
        return false;
    }
}
