package crelle.family.controller;

import crelle.family.model.PageBean;
import crelle.family.model.ao.MenuAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import crelle.family.common.ResponseResult;
import crelle.family.model.entity.Menu;
import crelle.family.model.entity.Role;
import crelle.family.service.MenuService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
@CrossOrigin
public class MenuController implements BaseController<Menu, MenuAO> {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "创建菜单")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Menu> create(Menu menu) {
        ResponseResult<Menu> responseResult = new ResponseResult<>();
        try {
            if (checkAddMenuParams(menu, responseResult)) {
                return responseResult;
            }
            List<Menu> menus = menuService.findMenusByName(menu.getName());
            if (!CollectionUtils.isEmpty(menus)) {
                responseResult.buildFail("菜单已经存在,无法创建！");
                return responseResult;
            }
            Menu menu1 = menuService.create(menu);
            responseResult.setData(menu1);

        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据菜单标识查询菜单")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Menu> queryById(Long id) {
        ResponseResult<Menu> responseResult = new ResponseResult<>();
        try {
            Menu menu = menuService.queryById(id);
            responseResult.setData(menu);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据条件分页查询菜单")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/page", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<Page<Menu>> pageByCondition(@RequestBody PageBean<MenuAO> pageBean) {
        ResponseResult<Page<Menu>> responseResult = new ResponseResult<>();
        try {
            Page<Menu> page = menuService.pageByCondition(pageBean);
            responseResult.setData(page);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }


    @ApiOperation(value = "查询所有菜单")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<List<Menu>> queryAll() {
        ResponseResult<List<Menu>> responseResult = new ResponseResult<>();
        try {
            List<Menu> menuList = menuService.queryAll();
            responseResult.setData(menuList);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "更新菜单")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> updateById(Long id, Menu menu) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            int result = menuService.update(id, menu);
            if (0 == result) {
                responseResult.buildFail("没有此菜单，无法更新！");
            }
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据菜单标识删除菜单")
    @ApiParam(required = true, name = "xx", value = "入参")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Override
    public ResponseResult<String> deleteById(Long id) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            menuService.queryById(id);
            menuService.deleteById(id);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            responseResult.buildFail("有角色绑定此菜单，无法删除！");
        } catch (NoSuchElementException noSuchElementException) {
            responseResult.buildFail("没有此菜单！");
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
//        if (CollectionUtils.isEmpty(menu.getRoles())) {
//            responseResult.buildFail("菜单对应的角色为空！");
//            return true;
//        }
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
