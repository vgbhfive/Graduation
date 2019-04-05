package cn.vgbhfive.graduationproject.service;

import cn.vgbhfive.graduationproject.entity.UserInfo;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.repository.UserInfoRepository;
import cn.vgbhfive.graduationproject.utils.EmailUtils;
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
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * 添加个人详细信息
     * @param userInfomation
     * @return 个人信息
     */
    public ReturnResult save(Map<String, String> userInfomation) {
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

    /**
     * 获取个人详细信息
     * @param userId
     * @return 个人信息
     */
    public ReturnResult one(Long userId) {
        UserInfo userInfo = userInfoRepository.getOne(userId);
        return ReturnResult.ok(userInfo);
    }

    /**
     * 更新个人详细信息
     * @param userinfo
     * @return 个人信息
     */
    public ReturnResult update(Map<String, String> userinfo) {
        Long id = Long.parseLong(userinfo.get("userId"));
        if (userInfoRepository.existsById(id)) {
            return ReturnResult.error(403, "No This User!");
        }

        UserInfo u = new UserInfo();
        u.setUserId(Long.parseLong(String.valueOf(userinfo.get("userId"))));
        u.setIdCard(String.valueOf(userinfo.get("idCard")));
        u.setEmail(String.valueOf(userinfo.get("email")));
        u.setPhone(String.valueOf(userinfo.get("phone")));
        u.setPreUpdateDate(new Date()); //修改时间

        userInfoRepository.deleteById(id);
        UserInfo save = userInfoRepository.save(u);
        EmailUtils.sendSimpleMail(u.getEmail(), "Change User Information!",
                "您修改了您的个人信息，若不是您自己修改,请及时修改您的密码，以防他人盗用！");
        return ReturnResult.ok(save);
    }

}
