package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.service.ManLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @time: 2019/03/17
 * @author: Vgbh
 */
@RestController
@RequestMapping("/manloan")
public class ManLoanController {

    @Autowired
    private ManLoanService manLoanService;

    @GetMapping(name = "/one/{manloanId}")
    public ReturnResult findOne(@PathVariable Long manloanId) {
        return manLoanService.one(manloanId);
    }

    @GetMapping(value = "/all/{userId}")
    public ReturnResult findAll(@PathVariable Long userId) {
        return manLoanService.all(userId);
    }

    @PostMapping(name = "/save")
    public ReturnResult save(@RequestBody Map<String, String> manLoan) {
        return manLoanService.save(manLoan);
    }

    @PostMapping(value = "/delete/{manloanId}")
    public ReturnResult deleteOne(@PathVariable Long manloanId) {
        return manLoanService.delete(manloanId);
    }

}
