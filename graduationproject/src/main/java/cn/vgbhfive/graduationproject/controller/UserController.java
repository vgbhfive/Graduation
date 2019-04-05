package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.service.UserInfoService;
import cn.vgbhfive.graduationproject.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ReturnResult registerUser(@RequestBody Map<String,String> registerUser){
        return userService.save(registerUser);
    }

    // /auth/login登陆接口，Spring Security自己实现

}
