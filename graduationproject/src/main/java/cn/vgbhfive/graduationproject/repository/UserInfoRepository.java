package cn.vgbhfive.graduationproject.repository;

import cn.vgbhfive.graduationproject.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @time:
 * @author: Vgbh
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
