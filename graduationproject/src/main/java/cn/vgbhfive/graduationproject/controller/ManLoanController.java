package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.service.ManLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @time: 2019/03/17
 * @author: Vgbh
 */
@RestController
@RequestMapping(name = "/loan")
public class ManLoanController {

    @Autowired
    private ManLoanService manLoanService;

    @GetMapping(name = "/one/{loanId}")
    public ReturnResult findone(@PathVariable Long loanId) {
        return manLoanService.findOne(loanId);
    }

    @GetMapping(name = "/all/{userId}")
    public ReturnResult findAll(@PathVariable Long userId) {
        return manLoanService.findAll(userId);
    }
}
