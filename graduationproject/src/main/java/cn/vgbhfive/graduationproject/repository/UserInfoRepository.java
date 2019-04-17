package cn.vgbhfive.graduationproject.repository;

import cn.vgbhfive.graduationproject.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @time:
 * @author: Vgbh
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    List<UserInfo> findAllByIdCard(String card);

    UserInfo getByIdCardAndPhone(String idCard, String phone);

}
