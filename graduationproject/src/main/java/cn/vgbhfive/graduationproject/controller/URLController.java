package cn.vgbhfive.graduationproject.controller;

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
public class URLController {

    @GetMapping(value = {"/home", "/"})
    public String homeURL() {
        return "home";
    }

    @GetMapping(value = "/register")
    public String registerURL() {
        return "view/register";
    }

    @GetMapping(value = "/login")
    public String loginURL() {
        return "view/login";
    }

    @GetMapping(value = "/back")
    public String backURL() {
        return "view/back";
    }

    @GetMapping(value = "/admin")
    public String adminURL() {
        return "view/admin";
    }

    @GetMapping(value = "/demo")
    public String demoURL() {
        return "view/demo";
    }

    @GetMapping(value = "/userinfo")
    public String userinfoURL() {
        return "view/userinfo";
    }

    @GetMapping(value = "/dayall")
    public String dayallURL() {
        return "view/dayall";
    }

}
