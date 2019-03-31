package cn.vgbhfive.graduationproject.service;

import cn.vgbhfive.graduationproject.entity.ManLoan;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.repository.ManLoanRepository;
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
public class ManLoanService {

    @Autowired
    private ManLoanRepository manLoanRepository;

    /**
     * 获取个人用户的所有贷款信息
     * @param userId
     * @return 贷款信息集合
     */
    public ReturnResult all(Long userId) {
        List<ManLoan> manLoans = manLoanRepository.findAllByUserId(userId);
        return ReturnResult.ok(manLoans);
    }

    /**
     * 获取一条个人贷款信息
     * @param manloanId
     * @return 贷款信息
     */
    public ReturnResult one(Long manloanId) {
        ManLoan manLoan = manLoanRepository.getOne(manloanId);
        return ReturnResult.ok(manLoan);
    }

    /**
     * 增加一条个人贷款信息
     * @param manLoan
     * @return 贷款信息
     */
    public ReturnResult save(Map<String, String> manLoan) {
        ManLoan m = new ManLoan();
        m.setUserId(Long.parseLong(manLoan.get("userId")));
        m.setMoney(Integer.parseInt(manLoan.get("money")));
        m.setType(manLoan.get("type"));
        m.setDatetimes(new Date());
        m.setDeadline(Integer.parseInt(manLoan.get("deadline")));
        m.setIntrate(Float.parseFloat(manLoan.get("intrate")));
        m.setContents(manLoan.get("content"));

        ManLoan save = manLoanRepository.save(m);
        return ReturnResult.ok(save);
    }

    /**
     * 删除一条个人贷款信息
     * @param manloanId
     * @return True
     */
    public ReturnResult delete(Long manloanId) {
        manLoanRepository.deleteById(manloanId);
        return ReturnResult.ok(true);
    }

}
