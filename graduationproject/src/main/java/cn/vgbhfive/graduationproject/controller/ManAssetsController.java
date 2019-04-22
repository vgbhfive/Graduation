package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.service.ManAssetsService;
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
@RequestMapping("/assets")
@Api(description = "个人财务管理")
public class ManAssetsController {

    @Autowired
    private ManAssetsService manAssetsService;

    @GetMapping(value = "/all/{userId}")
    @ApiOperation(value = "获取所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID")
    })
    public ReturnResult all(@PathVariable String userId) {
        return manAssetsService.all(userId);
    }

    @GetMapping(value = "/one/{id}")
    @ApiOperation(value = "获取单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "管理资产ID")
    })
    public ReturnResult one(@PathVariable String id) {
        return manAssetsService.all(id);
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "manAsset", value = "保存信息")
    })
    public ReturnResult save(@RequestBody Map<String, String> manAsset) {
        return manAssetsService.save(manAsset);
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "更新单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "manAsset", value = "更新信息")
    })
    public ReturnResult update(@RequestBody Map<String, String> manAsset) {
        return manAssetsService.update(manAsset);
    }

    @PostMapping(value = "/delete/{id}")
    @ApiOperation(value = "删除单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "管理资产ID")
    })
    public ReturnResult delete(@PathVariable String id) {
        return manAssetsService.delete(id);
    }





}
