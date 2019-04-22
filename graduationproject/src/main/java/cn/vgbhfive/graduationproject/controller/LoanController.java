package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.entity.Loan;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.service.LoanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(description = "贷款项目")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping(value = "/all")
    @ApiOperation(value = "获取所有")
    @ApiImplicitParams({})
    public ReturnResult findAll() {
        return loanService.all();
    }

    @GetMapping(value = "/one/{loanId}")
    @ApiOperation(value = "获取单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loanId", value = "贷款ID")
    })
    public ReturnResult findOne(@PathVariable Long loanId) {
        return loanService.one(loanId);
    }

    @GetMapping(value = "/allnocriteria")
    @ApiOperation(value = "分页获取所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页面"),
            @ApiImplicitParam(name = "size", value = "页面大小")
    })
    public Page<Loan> findAllNoCriteria(Integer page, Integer size) {
        return loanService.findAllNoCriteria(page, size);
    }

    @PostMapping(value = "/update")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "更新单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loan", value = "更新信息")
    })
    public ReturnResult updateOne(@RequestBody Map<String, String> loan) {
        return loanService.update(loan);
    }

    @PostMapping(value = "/save")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "保存单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loan", value = "保存信息")
    })
    public ReturnResult saveOne(@RequestBody Map<String, String> loan) {
        return loanService.save(loan);
    }

}
