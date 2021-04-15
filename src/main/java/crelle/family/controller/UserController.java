package crelle.family.controller;

import crelle.family.common.util.ResultUtils;
import crelle.family.model.PageBean;
import crelle.family.model.ao.UserAO;
import crelle.family.model.entity.Role;
import crelle.family.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import crelle.family.common.ResponseResult;
import crelle.family.model.entity.User;
import crelle.family.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author:crelle
 * @className:HelloController
 * @version:1.0.0
 * @date:2021/3/17
 * @description:XX
 **/
@RestController
@RequestMapping(value = "/user")
@Api(tags = "用户服务")
@CrossOrigin
public class UserController implements BaseController<User, UserAO> {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "新增用户")
    @ApiParam(required = true, name = "user", value = "入参")
    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<User> create(@RequestBody User user) {
        ResponseResult<User> responseResult = new ResponseResult<User>();
        try {
            if (!(null == user.getId())) {
                responseResult.buildFail("用户标识使用jpa自动生成，不需要传入！");
                return responseResult;
            }

            if (StringUtils.isBlank(String.valueOf(user.getUsername()))) {
                responseResult.buildFail("用户名为空！");
                return responseResult;
            }

            if (StringUtils.isBlank(String.valueOf(user.getPassword()))) {
                responseResult.buildFail("密码为空！");
                return responseResult;
            }
            List<User> users = userService.findUsersByUsername(user.getUsername());
            if (!CollectionUtils.isEmpty(users)) {
                responseResult.buildFail("用户名已经被占用！");
                return responseResult;
            }
            //给用户设置默认的访客角色
            Set<Role> roles = roleService.findRolesByName("ROLE_guest");
            user.setRoles(roles);
            User user2 = userService.create(user);
            responseResult.setData(user2);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "用户登录")
    @ApiParam(required = true, name = "user", value = "入参")
    @RequestMapping(value = "/xx", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> login(@RequestBody UserAO userAO) {
        ResponseResult<String> responseResult = new ResponseResult<String>();
        try {
            User user = userService.findUserByUsernameAndPassword(userAO);
            if (null == user) {
                return ResultUtils.fail("用户或者密码不正确！");
            }
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据用户标识查询用户")
    @ApiParam(required = true, name = "id", value = "入参")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<User> queryById(@PathVariable Long id) {
        ResponseResult<User> responseResult = new ResponseResult<>();
        try {
            User user = userService.queryById(id);
            responseResult.setData(user);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @Override
    public ResponseResult<Page<User>> pageByCondition(PageBean<UserAO> pageBean) {
        return null;
    }

    @ApiOperation(value = "查询所有用户")
    @ApiParam(required = true, name = "user", value = "入参")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<List<User>> queryAll() {
        ResponseResult<List<User>> responseResult = new ResponseResult<>();
        try {
            List<User> userList = userService.queryAll();
            responseResult.setData(userList);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "更新用户")
    @ApiParam(required = true, name = "user", value = "入参")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> updateById(@PathVariable Long id, @RequestBody User user) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            int result = userService.update(id, user);
            if (0 == result) {
                responseResult.buildFail("没有此用户，无法更新！");
            }
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据用户标识删除用户")
    @ApiParam(required = true, name = "user", value = "入参")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> deleteById(@PathVariable Long id) {
        ResponseResult<String> responseResult = new ResponseResult<String>();
        try {
            userService.deleteById(id);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }


}
