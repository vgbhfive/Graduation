package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.model.ReturnResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @time: 2019/03/17
 * @author: Vgbh
 */
@RestController
@RequestMapping(name = "/admin")
public class AdminController {

    @PostMapping(name = "/addfinanical")
    @PreAuthorize("hasRole('ADMIN')")
    public ReturnResult addFinanical(@RequestBody Map<String, Object> finanical) {

        return null;
    }

    @PostMapping(name = "/addloan")
    @PreAuthorize("hasRole('ADMIN')")
    public ReturnResult addLoan(@RequestBody Map<String, Object> loan) {

        return null;
    }

}
