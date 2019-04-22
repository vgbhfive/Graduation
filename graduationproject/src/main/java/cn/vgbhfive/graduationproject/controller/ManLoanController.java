package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.service.ManLoanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @time: 2019/03/17
 * @author: Vgbh
 */
@RestController
@RequestMapping("/manloan")
@Api(description = "贷款管理")
public class ManLoanController {

    @Autowired
    private ManLoanService manLoanService;

    @GetMapping(name = "/one/{manloanId}")
    @ApiOperation(value = "获取单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "manloanId", value = "贷款管理ID")
    })
    public ReturnResult findOne(@PathVariable Long manloanId) {
        return manLoanService.one(manloanId);
    }

    @GetMapping(value = "/all/{userId}")
    @ApiOperation(value = "获取所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID")
    })
    public ReturnResult findAll(@PathVariable Long userId) {
        return manLoanService.all(userId);
    }

    @PostMapping(name = "/save")
    @ApiOperation(value = "保存单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "manLoan", value = "保存信息")
    })
    public ReturnResult save(@RequestBody Map<String, String> manLoan) {
        return manLoanService.save(manLoan);
    }

    @PostMapping(value = "/delete/{manloanId}")
    @ApiOperation(value = "删除单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "manloanId", value = "贷款管理ID")
    })
    public ReturnResult deleteOne(@PathVariable Long manloanId) {
        return manLoanService.delete(manloanId);
    }

}
