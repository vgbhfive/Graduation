package cn.vgbhfive.graduationproject.service;

import cn.vgbhfive.graduationproject.entity.User;
import cn.vgbhfive.graduationproject.entity.UserInfo;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.repository.UserInfoRepository;
import cn.vgbhfive.graduationproject.repository.UserRepository;
import cn.vgbhfive.graduationproject.utils.EmailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ReturnedType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户注册操作服务
 *
 * @time: 2019/1/30
 * @author: Vgbh
 */
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 用户注册
     * @param registerUser
     * @return 注册成功信息
     */
    public ReturnResult save(Map<String, String> registerUser) {
        User user = new User();
        user.setUsername(registerUser.get("username"));
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password"))); //加密用户的密码
        user.setRole("ROLE_USER");
        User save = userRepository.save(user);

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(user.getId());
        userInfo.setRegisterDate(new Date());
        userInfo.setPreUpdateDate(new Date());
        UserInfo saveUserInfo = userInfoRepository.save(userInfo);

        logger.info(saveUserInfo.toString());
        logger.info(save.toString());
        return ReturnResult.ok(save);
    }

    /**
     * 查询是否重复注册用户名
     * @param username
     * @return boolean
     */
    public ReturnResult repeat(String username) {
        List<User> users = userRepository.findByUsernameIs(username);
        //logger.info(users.toString());
        return ReturnResult.ok(users.size() == 1 ? true : false);
    }

    /**
     * 更改用户密码
     * @param pwdMap
     * @return 更改后的用户基础登录信息
     */
    public ReturnResult updatePwd2(Map<String, String> pwdMap) {
        User beforeUser = userRepository.getOne(Long.parseLong(pwdMap.get("userId")));

        User user = new User();
        user.setId(beforeUser.getId());
        user.setUsername(beforeUser.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(pwdMap.get("password")));
        user.setRole(beforeUser.getRole());

        userRepository.delete(beforeUser); //删除原来的旧数据
        User save = userRepository.save(user); //插入更新后的数据
        return ReturnResult.ok(save);
    }

//    /**
//     * 更改用户密码的另一种实现方式
//     * @param pwdMap
//     * @return 更改后的用户基础登录信息
//     */
//    public ReturnResult updatePwd1(Map<String, String> pwdMap) {
//        userRepository.updatePasswordByUserId(bCryptPasswordEncoder.encode(pwdMap.get("password")),
//                Long.parseLong(pwdMap.get("userId")));
//
//        User afterUser = userRepository.getOne(Long.parseLong(pwdMap.get("userId"))); //新数据
//
//        return ReturnResult.ok(afterUser);
//    }

    /**
     * 更改用户密码的新一种实现方式
     * @param pwdMap
     * @return 更改后的用户基本登录信息
     */
    public ReturnResult updatePwd(Map<String, String> pwdMap) {
        User beforeUser = userRepository.getOne(Long.parseLong(pwdMap.get("userId")));
        beforeUser.setPassword(bCryptPasswordEncoder.encode(pwdMap.get("password")));

        userRepository.saveAndFlush(beforeUser);
        logger.info(beforeUser.toString());
        return ReturnResult.ok(beforeUser);
    }

}
