package cn.vgbhfive.graduationproject.service;

import cn.vgbhfive.graduationproject.entity.Financial;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.repository.FinanicalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @time: 2019/03/17
 * @author: Vgbh
 */
@Service
public class FinanicalService {

    private static final Logger logger = LoggerFactory.getLogger(FinanicalService.class);

    @Autowired
    private FinanicalRepository finanicalRepository;

    /**
     * 理财信息集合
     * @return 所有的理财信息
     */
    public ReturnResult findAll() {
        List<Financial> financials = finanicalRepository.findAll();
        return ReturnResult.ok(financials);
    }

    /**
     * 理财信息
     * @param id
     * @return 理财信息
     */
    public ReturnResult findOne(Long id) {
        Financial financial = finanicalRepository.getOne(id);
        return ReturnResult.ok(financial);
    }

    /**
     * 保存一条理财信息
     * @param financial
     * @return 理财信息
     */
    public ReturnResult save(Map<String, String> financial) {
        Financial f = new Financial();
        f.setName(financial.get("name"));
        f.setMoney(Integer.parseInt(financial.get("money")));
        f.setDeadline(Integer.parseInt(financial.get("deadline")));
        f.setIntrates(Float.parseFloat(financial.get("intrate")));
        f.setExpectReturn(f.getIntrates() * f.getMoney());
        f.setContent(financial.get("content"));

        Financial save = finanicalRepository.save(f);
        return ReturnResult.ok(save);
    }

    /**
     * 修改一条理财信息
     * @param financial
     * @return 理财信息
     */
    public ReturnResult update(Map<String, String> financial) {
        Long id = Long.valueOf(financial.get("id"));
        if (finanicalRepository.existsById(id)) {
            return ReturnResult.error(403, "No This Financial!");
        }

        Financial f = new Financial();
        f.setId(id);
        f.setName(financial.get("name"));
        f.setMoney(Integer.parseInt(financial.get("money")));
        f.setDeadline(Integer.parseInt(financial.get("deadline")));
        f.setIntrates(Float.parseFloat(financial.get("intrate")));
        f.setExpectReturn(f.getIntrates() * f.getMoney());
        f.setContent(financial.get("content"));

        finanicalRepository.deleteById(id);
        Financial save = finanicalRepository.save(f); //插入
        return ReturnResult.ok(save);
    }

}
