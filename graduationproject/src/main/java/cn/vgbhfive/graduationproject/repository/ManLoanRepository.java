package cn.vgbhfive.graduationproject.repository;

import cn.vgbhfive.graduationproject.entity.ManLoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @time:
 * @author: Vgbh
 */
public interface ManLoanRepository extends JpaRepository<ManLoan, Long> {

    List<ManLoan> findAllByUserId(Long userId);

}



