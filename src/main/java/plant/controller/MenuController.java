package plant.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import plant.common.ResponseResult;
import plant.common.enumeration.ResponseEnum;
import plant.model.entity.Menu;
import plant.service.MenuService;

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
@RequestMapping(value = "menu")
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
            Menu menu1 = menuService.saveMenu(menu);
            responseResult.setData(menu1);

        } catch (Exception e) {
            responseResult.setData(null);
            responseResult.setCode(ResponseEnum.FAIL.getCode());
            responseResult.setMessage(ResponseEnum.FAIL.getName());
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
            responseResult.setCode(ResponseEnum.FAIL.getCode());
            responseResult.setMessage(ResponseEnum.FAIL.getName());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据菜单标识删除菜单")
    @ApiParam(required = true, name = "menu", value = "入参")
    @RequestMapping(value = "/deleteMenuById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> deleteMenuById(@RequestBody Long menuId) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            menuService.deleteMenuById(menuId);
        } catch (Exception e) {
            responseResult.setCode(ResponseEnum.FAIL.getCode());
            responseResult.setMessage(ResponseEnum.FAIL.getName());
        }
        return responseResult;
    }

    @ApiOperation(value = "修改菜单")
    @ApiParam(required = true, name = "menu", value = "入参")
    @RequestMapping(value = "/updateMenu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String updateMenu(@RequestBody Menu menu) {
        return "hello";
    }

    @ApiOperation(value = "查询菜单")
    @ApiParam(required = true, name = "menu", value = "入参")
    @RequestMapping(value = "/queryMenus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<List<Menu>> queryMenus() {
        ResponseResult<List<Menu>> responseResult = new ResponseResult<>();
        try {
            List<Menu> menuList = menuService.queryMenus();
            responseResult.setData(menuList);
        } catch (Exception e) {
            responseResult.setCode(ResponseEnum.FAIL.getCode());
            responseResult.setMessage(ResponseEnum.FAIL.getName());
        }
        return responseResult;
    }
}
