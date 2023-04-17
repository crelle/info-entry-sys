package baseline.sysmgmt.controller;


import baseline.common.enumeration.ResponseEnum;
import baseline.common.exception.BusinessException;
import baseline.common.pojo.vo.ResponseResult;
import baseline.sysmgmt.pojo.entity.Menu;
import baseline.sysmgmt.pojo.query.MenuQuery;
import baseline.sysmgmt.pojo.vo.MenuVo;
import baseline.sysmgmt.service.MenuService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author crelle
 * @since 2022-10-01 12:06:26
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/sysmgmt/menu")
public class MenuController implements BaseController<MenuVo,Menu, MenuQuery> {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "创建菜单")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Menu> create(@RequestBody Menu menu) {
        try {
            Menu menus = menuService.queryByName(menu.getName());
            if (null != menus) {
                return ResponseResult.fail("新增的菜单已经存在!");
            }
            menuService.create(menu);
        } catch (Exception e) {
            throw  e;
        }
        return ResponseResult.ok();
    }

    @ApiOperation(value = "查询所有菜单")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<List<Menu>> queryAll() {
        return menuService.queryAllMenus();
    }


    @ApiOperation(value = "根据菜单标识查询菜单")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Menu> queryById(@PathVariable String id) {
        ResponseResult responseResult = ResponseResult.ok();
        try {
            Menu menu = menuService.queryById(id);
            responseResult.setData(menu);
        } catch (Exception e) {
            throw  e;
        }
        return responseResult;
    }

    @ApiOperation(value = "获取菜单顺序")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/getMenuSort", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Integer> getMenuSort() {
        try {
           return menuService.getMenuSort();
        } catch (Exception e) {
            throw  e;
        }
    }


    @ApiOperation(value = "分页查询角色")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/page", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<Menu>> page(@RequestBody Page<Menu> pageBean) {
        ResponseResult<Page<Menu>> responseResult = ResponseResult.ok();
        try {
            Page<Menu> page = menuService.page(pageBean);
            responseResult.setData(page);
        } catch (Exception e) {
            throw  e;
        }
        return responseResult;
    }

    @ApiOperation(value = "手动分页查询角色")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/manualPage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<MenuVo>> manualPage(Page<MenuQuery> pageBean) {
        return null;
    }

    @ApiOperation(value = "根据菜单标识更新菜单")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> updateById(@PathVariable String id, @RequestBody Menu menu) {
        ResponseResult<String> responseResult = ResponseResult.ok();
        try {
            Menu oldMenu = menuService.queryById(id);
            if (null == oldMenu) {
                responseResult.buildFail("要更新的菜单不存在！");
                return responseResult;
            }
            BeanUtils.copyProperties(menu, oldMenu, "id", "menus", "users");
            boolean isSuccess = menuService.update(oldMenu);
            if (!isSuccess) {
                responseResult.buildFail("更新菜单失败！");
            }
        } catch (Exception e) {
            throw  e;
        }
        return responseResult;
    }

    @ApiOperation(value = "根据菜单标识删除菜单")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> deleteById(@RequestBody String id) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            if (!menuService.deleteById(id)) {
                responseResult.buildFail("删除失败!");
            }
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            responseResult.buildFail("有用户在使用此菜单，无法删除！");
        } catch (NoSuchElementException noSuchElementException) {
            responseResult.buildFail("没有此菜单！");
        } catch (Exception e) {
            throw  e;
        }
        return responseResult;
    }

    @ApiOperation(value = "修改菜单目录")
    @ApiParam(required = true, name = "", value = "入参")
    @RequestMapping(value = "/updateMenu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> updateMenu(@RequestBody Set<Menu> menus) {
        try {
            menuService.updateParentMenu(menus);
        } catch (Exception e) {
            throw  e;
        }
        return ResponseResult.ok();
    }
}
