package com.dqcer.platformsystem.web.controller.login;

import com.dqcer.platformcommon.base.vo.Result;
import com.dqcer.platformsystem.web.service.login.LoginService;
import com.dqcer.platformsystem.web.vo.login.param.LoginParam;
import com.dqcer.platformsystem.web.vo.login.response.UserInfoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequestMapping("/sso")
@Api("登陆接口")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "查询用户" ,  notes="查询用户")
    @ApiImplicitParam(name = "cid", value = "客户id", required = true, dataType = "String")
    @PostMapping("/login")
    public Result login(@RequestBody @Validated LoginParam param, HttpServletRequest request){

        UsernamePasswordToken token = new UsernamePasswordToken(param.getUsername(), param.getPassword());
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        } catch (IncorrectCredentialsException | UnknownAccountException uae) {
            return Result.error("认证失败");
        }

        UserInfoResponse response = loginService.findUserByName(param.getUsername());
        return null;
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        System.out.println("------没有权限-------");
        return "403";
    }
}
