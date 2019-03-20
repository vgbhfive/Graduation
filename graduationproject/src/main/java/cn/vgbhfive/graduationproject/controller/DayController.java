package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @time: 2019/03/13
 * @author: Vgbh
 */
@RestController
@RequestMapping("/day")
public class DayController {

    @Autowired
    private DayService dayService;

    @GetMapping(value = "/all/{userId}")
    public ReturnResult getAllDayInOut(@PathVariable Long userId) {
        return dayService.findAllDayInOut(userId);
    }

    @PostMapping(value = "/save")
    public ReturnResult saveOne(@RequestBody Map<String, String> dayInOut) {
        return dayService.save(dayInOut);
    }

    @PostMapping(value = "/updateone")
    public ReturnResult updateOne(@RequestBody Map<String, String> dayInOut) {
        return dayService.update(dayInOut);
    }

    @GetMapping(value = "/total/{userId}")
    public ReturnResult total(@PathVariable Long userId) {
        return dayService.total(userId);
    }

}
