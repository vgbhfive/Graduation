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

    @GetMapping("/all/{userId}")
    public ReturnResult getAllDayInOut(@PathVariable Long userId) {
        return dayService.findAllDayInOut(userId);
    }

    @PostMapping("/saveone")
    public ReturnResult saveOne(@RequestBody Map<String, String> dayInOut) {
        return dayService.save(dayInOut);
    }

    @PostMapping("/updateone")
    public ReturnResult updateOne(@RequestBody Map<String, String> dayInOut) {
        return dayService.update(dayInOut);
    }

}
