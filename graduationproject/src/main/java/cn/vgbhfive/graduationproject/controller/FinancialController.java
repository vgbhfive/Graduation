package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.service.FinanicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @time: 2019/03/17
 * @author: Vgbh
 */
@RestController
@RequestMapping("/financial")
public class FinancialController {

    @Autowired
    private FinanicalService finanicalService;

    @GetMapping(value = "/all")
    public ReturnResult findAll() {
        return finanicalService.findAll();
    }

    @GetMapping(value = "/one/{id}")
    public ReturnResult findOne(@PathVariable Long id) {
        return finanicalService.findOne(id);
    }

    @PostMapping(value = "/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ReturnResult save(@RequestBody Map<String, String> financial) {
        return finanicalService.save(financial);
    }

    @PostMapping(value = "/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ReturnResult update(@RequestBody Map<String, String> financial) {
        return finanicalService.update(financial);
    }


}
