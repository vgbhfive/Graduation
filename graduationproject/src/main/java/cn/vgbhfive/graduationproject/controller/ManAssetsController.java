package cn.vgbhfive.graduationproject.controller;

import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.service.ManAssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @time: 2019/03/17
 * @author: Vgbh
 */
@RestController
@RequestMapping("/assets")
public class ManAssetsController {

    @Autowired
    private ManAssetsService manAssetsService;

    @GetMapping(value = "/all/{userId}")
    public ReturnResult all(@PathVariable String userId) {
        return manAssetsService.all(userId);
    }

    @GetMapping(value = "/one/{id}")
    public ReturnResult one(@PathVariable String id) {
        return manAssetsService.all(id);
    }

    @PostMapping(value = "/save")
    public ReturnResult save(@RequestBody Map<String, String> manAsset) {
        return manAssetsService.save(manAsset);
    }

    @PostMapping(value = "/update")
    public ReturnResult update(@RequestBody Map<String, String> manAsset) {
        return manAssetsService.update(manAsset);
    }

    @PostMapping(value = "/delete/{id}")
    public ReturnResult delete(@PathVariable String id) {
        return manAssetsService.delete(id);
    }





}
