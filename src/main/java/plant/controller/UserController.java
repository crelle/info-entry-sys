package plant.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import plant.common.ResponseResult;
import plant.common.enumeration.ResponseEnum;
import plant.model.entity.User;
import plant.service.impl.UserServiceImpl;

import javax.print.attribute.standard.MediaTray;
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
            User user1 = userService.addUser(user);
            responseResult.setData(user1);
        } catch (Exception e) {
            responseResult.setCode(ResponseEnum.FAIL.getCode());
            responseResult.setMessage(ResponseEnum.FAIL.getName());
        }
        return responseResult;
    }

    @ApiOperation(value = "删除用户")
    @ApiParam(required = true, name = "user", value = "入参")
    @RequestMapping(value = "deleteUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String deleteUser(@RequestBody User user) {
        return "admin";
    }

    @ApiOperation(value = "根据用户标识删除用户")
    @ApiParam(required = true, name = "user", value = "入参")
    @RequestMapping(value = "deleteUserById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<String> deleteUserById(@RequestBody Long userId) {
        ResponseResult<String> responseResult = new ResponseResult<String>();
        try {
            userService.deleteUserById(userId);
        } catch (Exception e) {
            responseResult.setCode(ResponseEnum.FAIL.getCode());
            responseResult.setMessage(ResponseEnum.FAIL.getName());
        }
        return responseResult;
    }

    @ApiOperation(value = "更新用户")
    @ApiParam(required = true, name = "user", value = "入参")
    @RequestMapping(value = "updateUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String updateUser(@RequestBody User user) {
        return "user";
    }

    @ApiOperation(value = "查询用户")
    @ApiParam(required = true, name = "user", value = "入参")
    @RequestMapping(value = "queryUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<List<User>> queryUser(@RequestBody User user) {
        ResponseResult<List<User>> responseResult = new ResponseResult<>();
        try {
            List<User> userList = userService.queryUsers();
        } catch (Exception e) {
            responseResult.setCode(ResponseEnum.FAIL.getCode());
            responseResult.setMessage(ResponseEnum.FAIL.getName());
        }
        return responseResult;
    }

    @ApiOperation(value = "根据用户标识查询用户")
    @ApiParam(required = true, name = "user", value = "入参")
    @RequestMapping(value = "queryUserById", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseResult<Optional<User>> queryUserById(@RequestBody Long id ) {
        ResponseResult<Optional<User>> responseResult = new ResponseResult<>();
        try {
            Optional<User> user = userService.queryUserById(id);
            responseResult.setData(user);
        } catch (Exception e) {
            responseResult.setCode(ResponseEnum.FAIL.getCode());
            responseResult.setMessage(ResponseEnum.FAIL.getName());
        }
        return responseResult;
    }
}
