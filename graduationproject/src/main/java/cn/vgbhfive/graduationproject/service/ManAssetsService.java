package cn.vgbhfive.graduationproject.service;

import cn.vgbhfive.graduationproject.entity.ManAsset;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.repository.ManAssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @time: 2019/03/17
 * @author: Vgbh
 */
@Service
public class ManAssetsService {

    @Autowired
    private ManAssetsRepository manAssetsRepository;

    /**
     * 查询所有的个人资产信息
     * @param userId
     * @return 个人资产信息集合
     */
    public ReturnResult all(String userId) {
        Long u = Long.parseLong(userId);
        List<ManAsset> manAssets = manAssetsRepository.findAllByUserId(u);
        return ReturnResult.ok(manAssets);
    }

    /**
     * 查询个人资产信息
     * @param id
     * @return 个人资产信息
     */
    public ReturnResult one(String id) {
        Long i = Long.parseLong(id);
        ManAsset manAsset = manAssetsRepository.getOne(i);
        return ReturnResult.ok(manAsset);
    }

    /**
     * 保存一条个人资产信息
     * @param manAsset
     * @return 个人资产信息
     */
    public ReturnResult save(Map<String, String> manAsset) {
        ManAsset man = new ManAsset();
        man.setUserId(Long.valueOf(manAsset.get("userId")));
        man.setMoney(Integer.parseInt(manAsset.get("money")));
        man.setDatetimes(new Date());
        man.setCycle(Integer.parseInt(manAsset.get("cycle")));
        man.setProperty(manAsset.get("property"));
        man.setSource(manAsset.get("source"));
        man.setContents(manAsset.get("content"));

        ManAsset save = manAssetsRepository.save(man);
        return ReturnResult.ok(save);
    }

    /**
     * 更新一条个人资产信息
     * @param manAsset
     * @return 个人资产信息
     */
    public ReturnResult update(Map<String, String> manAsset) {
        Long id = Long.parseLong(manAsset.get("id"));

        if (manAssetsRepository.existsById(id)) {
            return ReturnResult.error(403, "No This ManAsset!");
        }
        ManAsset man = new ManAsset();
        man.setId(id);
        man.setUserId(Long.valueOf(manAsset.get("userId")));
        man.setMoney(Integer.parseInt(manAsset.get("money")));
        man.setDatetimes(new Date());
        man.setCycle(Integer.parseInt(manAsset.get("cycle")));
        man.setProperty(manAsset.get("property"));
        man.setSource(manAsset.get("source"));
        man.setContents(manAsset.get("content"));

        manAssetsRepository.deleteById(id);
        ManAsset save = manAssetsRepository.save(man);
        return ReturnResult.ok(save);
    }

    /**
     * 删除一条个人资产信息
     * @param id
     * @return 个人资产信息
     */
    public ReturnResult delete(String id) {
        Long i = Long.parseLong(id);
        manAssetsRepository.deleteById(i);
        return ReturnResult.ok(true);
    }

}
