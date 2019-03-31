package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.entity.Loan;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @time: 2019/03/18
 * @author: Vgbh
 */
@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping(value = "/all")
    public ReturnResult findAll() {
        return loanService.all();
    }

    @GetMapping(value = "/one/{loanId}")
    public ReturnResult findOne(@PathVariable Long loanId) {
        return loanService.one(loanId);
    }

    @GetMapping(value = "/allnocriteria")
    public Page<Loan> findAllNoCriteria(Integer page, Integer size) {
        return loanService.findAllNoCriteria(page, size);
    }

    @PostMapping(value = "/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ReturnResult updateOne(@RequestBody Map<String, String> loan) {
        return loanService.update(loan);
    }

    @PostMapping(value = "/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ReturnResult saveOne(@RequestBody Map<String, String> loan) {
        return loanService.save(loan);
    }

}
