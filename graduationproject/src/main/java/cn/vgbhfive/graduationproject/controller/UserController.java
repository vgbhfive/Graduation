package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.service.UserInfoService;
import cn.vgbhfive.graduationproject.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户信息
 *
 * @time: 2019/1/30
 * @author: Vgbh
 */
@RestController
@RequestMapping("/auth")
@Api(description = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    @ApiOperation(value = "注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "registerUser", value = "注册信息")
    })
    public ReturnResult registerUser(@RequestBody Map<String,String> registerUser){
        return userService.save(registerUser);
    }

    // /auth/login登陆接口，Spring Security自己实现

    @PostMapping(value = "/updatepwd")
    @ApiOperation(value = "更新密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pwdMap", value = "更新信息")
    })
    public ReturnResult updatePwd(@RequestBody Map<String, String> pwdMap) {
        return userService.updatePwd(pwdMap);
    }

}
