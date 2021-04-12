package crelle.family.controller;


import crelle.family.common.ResponseResult;
import crelle.family.common.util.ResultUtils;
import crelle.family.common.util.VerificationCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *@author:crelle
 *@date:2021/4/12
 *@title:
 *@description:
 *@params:
 *@return:
 *@throw:
 */
@RestController
@Api(tags = "登录服务")
public class LoginController {

    @ApiOperation(value = "登录")
    @ApiParam(required = true, name = "", value = "入参")
    @GetMapping("/login")
    public ResponseResult<String> login() {
        return ResultUtils.fail("尚未登录，请登录!");
    }

    @ApiOperation(value = "注销")
    @ApiParam(required = true, name = "", value = "入参")
    @GetMapping("/logout")
    public ResponseResult<String> logout() {
        return ResultUtils.fail("尚未登录，请登录!");
    }

    @GetMapping("/verifyCode")
    @ApiOperation(value = "获取验证码")
    @ApiParam(required = true, name = "request and resp", value = "入参")
    public void verifyCode(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        HttpSession session = request.getSession(true);
        session.setAttribute("verifyCode", text);
        System.out.println("##############################验证码="+text);
        VerificationCode.output(image,resp.getOutputStream());
    }
}
