package cn.vgbhfive.graduationproject.repository;

import cn.vgbhfive.graduationproject.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @time: 2019/03/18
 * @author: Vgbh
 */
@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

}
