package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.entity.Financial;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.service.FinanicalService;
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
 * @time: 2019/03/17
 * @author: Vgbh
 */
@RestController
@RequestMapping("/financial")
@Api(description = "理财项目")
public class FinancialController {

    @Autowired
    private FinanicalService finanicalService;

    @GetMapping(value = "/all")
    @ApiOperation(value = "获取所有")
    @ApiImplicitParams({})
    public ReturnResult findAll() {
        return finanicalService.findAll();
    }

    @GetMapping(value = "/one/{id}")
    @ApiOperation(value = "获取单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "理财ID")
    })
    public ReturnResult findOne(@PathVariable Long id) {
        return finanicalService.findOne(id);
    }

    @PostMapping(value = "/save")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "保存单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "financial", value = "保存信息")
    })
    public ReturnResult save(@RequestBody Map<String, String> financial) {
        return finanicalService.save(financial);
    }

    @PostMapping(value = "/update")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "更新单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "financial", value = "更新信息")
    })
    public ReturnResult update(@RequestBody Map<String, String> financial) {
        return finanicalService.update(financial);
    }

    @GetMapping(value = "/allnocriteria")
    @ApiOperation(value = "获取所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数"),
            @ApiImplicitParam(name = "size", value = "每页大小")
    })
    public Page<Financial> findAllNoCritreia(Integer page, Integer size) {
        return finanicalService.findAllNoCritreia(page, size);
    }

}
