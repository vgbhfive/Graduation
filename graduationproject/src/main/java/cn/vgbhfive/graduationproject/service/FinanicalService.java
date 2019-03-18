package cn.vgbhfive.graduationproject.service;

import cn.vgbhfive.graduationproject.entity.FinancialInfo;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.repository.FinanicalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<FinancialInfo> all = finanicalRepository.findAll();
        return ReturnResult.ok(all);
    }

    /**
     * 理财信息
     * @param id
     * @return 理财信息
     */
    public ReturnResult findOne(Long id) {
        FinancialInfo financial = finanicalRepository.getOne(id);
        return ReturnResult.ok(financial);
    }

}
