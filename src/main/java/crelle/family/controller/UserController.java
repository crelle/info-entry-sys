package crelle.family.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import crelle.family.common.ResponseResult;
import crelle.family.model.entity.User;
import crelle.family.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Optional;

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
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "新增用户")
    @ApiParam(required = true, name = "user", value = "入参")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<User> addUser(@RequestBody User user) {
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
            User user1 = userService.addUser(user);
            responseResult.setData(user1);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据用户标识删除用户")
    @ApiParam(required = true, name = "user", value = "入参")
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> deleteUserById(@RequestBody Long userId) {
        ResponseResult<String> responseResult = new ResponseResult<String>();
        try {
            userService.deleteUserById(userId);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "更新用户")
    @ApiParam(required = true, name = "user", value = "入参")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> updateUser(@RequestBody User user) {
        ResponseResult<String> responseResult = new ResponseResult<>();
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "查询所有用户")
    @ApiParam(required = true, name = "user", value = "入参")
    @RequestMapping(value = "/queryUsers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<List<User>> queryUser() {
        ResponseResult<List<User>> responseResult = new ResponseResult<>();
        try {
            List<User> userList = userService.queryUsers();
            responseResult.setData(userList);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据用户标识查询用户")
    @ApiParam(required = true, name = "user", value = "入参")
    @RequestMapping(value = "/queryUserById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Optional<User>> queryUserById(@RequestBody Long id) {
        ResponseResult<Optional<User>> responseResult = new ResponseResult<>();
        try {
            Optional<User> user = userService.queryUserById(id);
            responseResult.setData(user);
        } catch (Exception e) {
            responseResult.buildFail(e.getMessage());
        }
        return responseResult;
    }
}
