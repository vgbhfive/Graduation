package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.service.DayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @time: 2019/03/13
 * @author: Vgbh
 */
@RestController
@RequestMapping("/day")
@Api(description = "个人日常支出收入")
public class DayController {

    @Autowired
    private DayService dayService;

    @GetMapping(value = "/all/{userId}")
    @ApiOperation(value = "获取所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID")
    })
    public ReturnResult getAllDayInOut(@PathVariable Long userId) {
        return dayService.findAllDayInOut(userId);
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dayInOut", value = "保存信息")
    })
    public ReturnResult saveOne(@RequestBody Map<String, String> dayInOut) {
        return dayService.save(dayInOut);
    }

    @PostMapping(value = "/updateone")
    @ApiOperation(value = "更新单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dayInOut", value = "更新信息")
    })
    public ReturnResult updateOne(@RequestBody Map<String, String> dayInOut) {
        return dayService.update(dayInOut);
    }

    @GetMapping(value = "/total/{userId}")
    @ApiOperation(value = "计算所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID")
    })
    public ReturnResult total(@PathVariable Long userId) {
        return dayService.total(userId);
    }

}
