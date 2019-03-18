package cn.vgbhfive.graduationproject.repository;

import cn.vgbhfive.graduationproject.entity.DayInOut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @time: 2019/03/13
 * @author: Vgbh
 */
public interface DayRepository extends JpaRepository<DayInOut, Long> {

    List<DayInOut> findAllByUserId(Long userId);


}
