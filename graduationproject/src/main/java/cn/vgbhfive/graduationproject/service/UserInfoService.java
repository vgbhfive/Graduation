package cn.vgbhfive.graduationproject.service;

import cn.vgbhfive.graduationproject.entity.UserInfo;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.repository.UserInfoRepository;
import cn.vgbhfive.graduationproject.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @time: 2019/03/17
 * @author: Vgbh
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * 添加个人信息详情
     * @param userInfomation
     * @return 个人信息
     */
    public ReturnResult save(Map<String, Object> userInfomation) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(Long.parseLong(String.valueOf(userInfomation.get("userId"))));
        userInfo.setIdCard(String.valueOf(userInfomation.get("idCard")));
        userInfo.setEmail(String.valueOf(userInfomation.get("email")));
        userInfo.setPhone(String.valueOf(userInfomation.get("phone")));
        userInfo.setRegisterDate(new Date()); //注册时间
        userInfo.setPreUpdateDate(new Date()); //修改时间

        userInfo = userInfoRepository.save(userInfo);
        EmailUtils.sendSimpleMail(userInfo.getEmail(), "注册成功！",
                "感谢您使用本理财系统，我们将为您竭尽所能，时刻保护好您的财产，再次感谢您！");
        return ReturnResult.ok(userInfo);
    }

}
