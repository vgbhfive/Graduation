package cn.vgbhfive.graduationproject.service;

import cn.vgbhfive.graduationproject.entity.ManagementLoan;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.repository.ManLoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @time: 2019/03/17
 * @author: Vgbh
 */
@Service
public class ManLoanService {

    @Autowired
    private ManLoanRepository manLoanRepository;

    /**
     * 获取用户的所有贷款信息
     * @param userId
     * @return 贷款信息集合
     */
    public ReturnResult findAll(Long userId) {
        List<ManagementLoan> all = manLoanRepository.findAllByUserId(userId);
        return ReturnResult.ok(all);
    }

    /**
     * 获取贷款信息
     * @param loanId
     * @return 贷款信息
     */
    public ReturnResult findOne(Long loanId) {
        ManagementLoan loan = manLoanRepository.getOne(loanId);
        return ReturnResult.ok(loan);
    }



}
