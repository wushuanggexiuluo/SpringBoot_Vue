package com.scm.myblog.controller;

import com.scm.myblog.entity.Code;
import com.scm.myblog.entity.DTO.LoginDto;
import com.scm.myblog.entity.VO.Result;
import com.scm.myblog.service.impl.LoginServiceImpl;
import com.scm.myblog.utils.WebUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Api(tags = "登陆控制器")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Blog")
public class LoginController {
    @Autowired
    public LoginServiceImpl loginService;
    @ApiOperation("开始登录")
    @PostMapping("/Login")
    public Result startLogin(HttpServletRequest request,
                              HttpServletResponse response,
                              @RequestBody @Valid LoginDto loginDto,
                              BindingResult b
    ) {
        //参数校验通过后才进行操作
        if(!b.hasErrors()){

            return loginService.Login(loginDto);
        }
        else {
            throw new RuntimeException();
        }
    }
    @ApiOperation("用户注册")
    @PostMapping("/Register")
    public Result Register(@RequestBody @ApiParam("登陆dto对象")LoginDto loginDto) {
        return loginService.Register(loginDto);
    }
    @ApiOperation("判断用户是否存在")
    @PostMapping("/isExistUser")
    public Result isExistUser(@RequestBody @ApiParam("登陆dto对象")LoginDto loginDto) {
        return loginService.isExistUser(loginDto);
    }
    @ApiOperation("获取在线人数")
    @GetMapping("/getOnInternatCount")
    public Result getCount(HttpServletRequest request) {
        WebUtils.getOnInternatCount(request);
        return new Result(null, 1, "1");
    }
    @ApiOperation("退出登录")
    @GetMapping("/CancelLogin")
    public Result CancelLogin(HttpServletRequest request, HttpServletResponse response) {
        WebUtils.removeUserSession(request);
        loginService.logout();
        System.out.println("用户退出成功！");
        return new Result(null, Code.Cancel_OK, "用户退出成功");
    }
}
