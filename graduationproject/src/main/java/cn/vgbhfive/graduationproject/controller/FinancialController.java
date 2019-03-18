package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.service.FinanicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @time: 2019/03/17
 * @author: Vgbh
 */
@RestController
@RequestMapping("/finan")
public class FinancialController {

    @Autowired
    private FinanicalService finanicalService;

    /**
     * 理财信息集合
     * @return 理财项目的所有信息
     */
    @GetMapping("/all")
    public ReturnResult findAll() {
        return finanicalService.findAll();
    }

    /**
     * 理财信息
     * @param id
     * @return 单个理财信息
     */
    @GetMapping("/one/{id}")
    public ReturnResult findOne(@PathVariable Long id) {
        return finanicalService.findOne(id);
    }



}
