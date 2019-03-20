package cn.vgbhfive.graduationproject.service;

import cn.vgbhfive.graduationproject.entity.Loan;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.repository.LoanRepository;
import org.hibernate.loader.plan.exec.process.spi.ReturnReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

/**
 * @time: 2019/03/18
 * @author: Vgbh
 */
@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    /**
     * 持久化贷款数据信息
     * @param loan
     * @return 贷款信息
     */
    public ReturnResult save(Map<String, String> loan) {
        Loan l = new Loan();
        l.setMoney(Integer.parseInt(loan.get("money")));
        l.setReturnDate(Integer.parseInt(loan.get("returndate")));
        l.setType(loan.get("type"));
        l.setIntrate(Float.parseFloat(loan.get("intrate")));
        l.setOdds(Float.parseFloat(loan.get("odds")));
        l.setContent(loan.get("content"));

        Loan save = loanRepository.save(l);

        return ReturnResult.ok(save);
    }

    /**
     * 所有的贷款信息
     * @return 贷款信息集合
     */
    public ReturnResult all() {
        List<Loan> loans = loanRepository.findAll();
        return ReturnResult.ok(loans);
    }

    /**
     * 一条贷款信息
     * @return 贷款信息
     */
    public ReturnResult one(Long loanId) {
        Loan loan = loanRepository.getOne(loanId);
        return ReturnResult.ok(loan);
    }

    /**
     * 更新一条贷款信息
     * @param loan
     * @return 贷款信息
     */
    public ReturnResult update(Map<String, String> loan) {
        Loan sel = loanRepository.getOne(Long.parseLong(loan.get("loanId")));
        if (sel == null) {
            return ReturnResult.error(403, "No This Loan!");
        }
        Loan l = new Loan();
        l.setLoanId(Long.parseLong(loan.get("loanId")));
        l.setMoney(Integer.parseInt(loan.get("money")));
        l.setReturnDate(Integer.parseInt(loan.get("returnDate")));
        l.setType(loan.get("type"));
        l.setOdds(Float.parseFloat(loan.get("odds")));
        l.setIntrate(Float.parseFloat(loan.get("intrate")));
        l.setContent(loan.get("content"));

        loanRepository.delete(sel);
        Loan save = loanRepository.save(l);

        return ReturnResult.ok(save);
    }

}
