package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.service.UserInfoService;
import cn.vgbhfive.graduationproject.service.UserService;
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
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{username}")
    public ReturnResult repeatUser(@PathVariable String username) {
        return userService.repeat(username);
    }

    @PostMapping(value = "/save")
    public ReturnResult save(@RequestBody Map<String, String> userinfo) {
        return userInfoService.save(userinfo);
    }

    @GetMapping(value = "/one/{userId}")
    public ReturnResult one(@PathVariable String userId) {
        return userInfoService.one(userId);
    }

    @PostMapping(value = "/update")
    public ReturnResult update(@RequestBody Map<String, String> userinfo) {
        return userInfoService.update(userinfo);
    }

//    @PostMapping(value = "/check")
//    public ReturnResult check(@RequestBody Map<String, String> checkMap) {
//        return userInfoService.check(checkMap);
//    }

    @GetMapping(value = "/checkcard/{card}")
    public ReturnResult checkcard(@PathVariable String card) {
        return userInfoService.repeatIdCard(card);
    }

}
