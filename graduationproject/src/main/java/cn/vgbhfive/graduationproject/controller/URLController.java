package cn.vgbhfive.graduationproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * URL请求
 *
 * @time: 2019/1/30
 * @author: Vgbh
 */
@Controller
@Api(description = "URL管理")
public class URLController {

    @GetMapping(value = {"/home", "/"})
    @ApiOperation(value = "主界面")
    public String homeURL() {
        return "home";
    }

    @GetMapping(value = "/register")
    @ApiOperation(value = "注册")
    public String registerURL() {
        return "view/register";
    }

    @GetMapping(value = "/login")
    @ApiOperation(value = "登录")
    public String loginURL() {
        return "view/login";
    }

    @GetMapping(value = "/back")
    @ApiOperation(value = "找回")
    public String backURL() {
        return "view/back";
    }

    @GetMapping(value = "/admin")
    @ApiOperation(value = "管理员")
    public String adminURL() {
        return "view/admin";
    }

    @GetMapping(value = "/demo")
    @ApiOperation(value = "测试")
    public String demoURL() {
        return "view/demo";
    }

    @GetMapping(value = "/userinfo")
    @ApiOperation(value = "用户信息")
    public String userinfoURL() {
        return "view/userinfo";
    }

    @GetMapping(value = "/dayall")
    @ApiOperation(value = "日常收支信息")
    public String dayallURL() {
        return "view/dayall";
    }

}
