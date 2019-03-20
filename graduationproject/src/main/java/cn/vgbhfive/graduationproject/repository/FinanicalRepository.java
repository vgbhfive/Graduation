package cn.vgbhfive.graduationproject.repository;

import cn.vgbhfive.graduationproject.entity.Financial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @time: 2019/03/17
 * @author: Vgbh
 */
@Repository
public interface FinanicalRepository extends JpaRepository<Financial, Long> {

}
