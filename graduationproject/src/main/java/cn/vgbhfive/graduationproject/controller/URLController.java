package cn.vgbhfive.graduationproject.controller;

import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homeURL() {
        return "home";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerURL() {
        return "view/register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginURL() {
        return "view/login";
    }


}
