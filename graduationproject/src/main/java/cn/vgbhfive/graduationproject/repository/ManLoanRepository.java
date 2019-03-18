package cn.vgbhfive.graduationproject.repository;

import cn.vgbhfive.graduationproject.entity.ManagementLoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @time:
 * @author: Vgbh
 */
public interface ManLoanRepository extends JpaRepository<ManagementLoan, Long> {

    List<ManagementLoan> findAllByUserId(Long userId);

}



