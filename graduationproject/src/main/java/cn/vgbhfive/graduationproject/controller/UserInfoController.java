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

import javax.xml.soap.SAAJResult;
import java.util.Map;

/**
 * @time:
 * @author: Vgbh
 */
@RestController
@RequestMapping("/userinfo")
@ResponseBody
@Api(description = "用户信息管理")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{username}")
    @ApiOperation(value = "检查是否重复用户名")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名")
    })
    public ReturnResult repeatUser(@PathVariable String username) {
        return userService.repeat(username);
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userinfo", value = "保存信息")
    })
    public ReturnResult save(@RequestBody Map<String, String> userinfo) {
        return userInfoService.save(userinfo);
    }

    @GetMapping(value = "/one/{userId}")
    @ApiOperation(value = "获取单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID")
    })
    public ReturnResult one(@PathVariable String userId) {
        return userInfoService.one(userId);
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "baocundange")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userindo", value = "用户信息")
    })
    public ReturnResult update(@RequestBody Map<String, String> userinfo) {
        return userInfoService.update(userinfo);
    }

    @PostMapping(value = "/check")
    @ApiOperation(value = "检查是否重复注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "checkMap", value = "检查信息")
    })
    public ReturnResult check(@RequestBody Map<String, String> checkMap) {
        return userInfoService.check(checkMap);
    }

    @GetMapping(value = "/checkcard/{card}")
    @ApiOperation(value = "检验身份证是否重复")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "card", value = "身份证号")
    })
    public ReturnResult checkcard(@PathVariable String card) {
        return userInfoService.repeatIdCard(card);
    }

}
