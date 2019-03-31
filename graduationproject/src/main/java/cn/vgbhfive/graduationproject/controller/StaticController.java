package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.entity.ManAsset;
import cn.vgbhfive.graduationproject.entity.ManLoan;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @time: 2019/03/30
 * @author: Vgbh
 */
@RestController
@RequestMapping("/static")
public class StaticController {

    @GetMapping("/loans")
    public ReturnResult getManloans() {
        List<ManLoan> loans = new ArrayList<>();


        return ReturnResult.ok(loans);
    }

    @GetMapping("/assets")
    public ReturnResult getManassets() {
        List<ManAsset> assets = new ArrayList<>();


        return ReturnResult.ok(assets);
    }

}
