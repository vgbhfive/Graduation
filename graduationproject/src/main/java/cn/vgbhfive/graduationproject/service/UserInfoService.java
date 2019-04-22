package cn.vgbhfive.graduationproject.service;

import cn.vgbhfive.graduationproject.entity.UserInfo;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.repository.UserInfoRepository;
import cn.vgbhfive.graduationproject.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Autowired
    private EmailUtils emailUtils;

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
        emailUtils.sendSimpleMail(userInfo.getEmail(), "注册成功！",
                "感谢您使用本理财系统，我们将为您竭尽所能，时刻保护好您的财产，再次感谢您！");
        return ReturnResult.ok(userInfo);
    }

    /**
     * 获取个人详细信息
     * @param userId
     * @return 个人信息
     */
    public ReturnResult one(String userId) {
        Long user = Long.parseLong(userId);
        UserInfo userInfo = userInfoRepository.getOne(user);
        return ReturnResult.ok(userInfo);
    }

    /**
     * 更新个人详细信息
     * @param userinfo
     * @return 个人信息
     */
    public ReturnResult update(Map<String, String> userinfo) {
        Long id = Long.parseLong(userinfo.get("userId"));
        UserInfo ui = userInfoRepository.getOne(id);
        if (ui == null) {
            return ReturnResult.error(403, "No This User!");
        }

        UserInfo u = new UserInfo();
        u.setUserId(id);
        u.setIdCard(String.valueOf(userinfo.get("idCard")));
        u.setEmail(String.valueOf(userinfo.get("email")));
        u.setPhone(String.valueOf(userinfo.get("phone")));
        u.setRegisterDate(ui.getRegisterDate());
        u.setPreUpdateDate(new Date()); //修改时间

        userInfoRepository.deleteById(id);
        UserInfo save = userInfoRepository.save(u);
        emailUtils.sendSimpleMail(u.getEmail(), "Change User Information!", "您修改了您的个人信息，若不是您自己修改,请及时修改您的密码，以防他人盗用！");
        return ReturnResult.ok(save);
    }

    /**
     * 检查用户信息（手机号和身份证号）的正确性
     * @param userinfo
     * @return 错误信息或True
     */
    public ReturnResult check(Map<String, String> userinfo) {
        String phone = userinfo.get("phone");
        String card = userinfo.get("idCard");
        UserInfo ui = userInfoRepository.getByIdCardAndPhone(card, phone);
        if (ui != null && ui.getIdCard().equals(card) && ui.getPhone().equals(phone)) {
            return ReturnResult.ok(ui);
        }

        return ReturnResult.error(403, "手机号或身份证号不正确！");
    }

    /**
     * 检查是否有重复的身份信息
     * @param card
     * @return True/False(有/无)
     */
    public ReturnResult repeatIdCard(String card) {
        List<UserInfo> userInfos = userInfoRepository.findAllByIdCard(card);
        if (userInfos.size() > 1) {
            return ReturnResult.error(403, "该身份证号已使用！");
        }

        return ReturnResult.ok(true);
    }

}
