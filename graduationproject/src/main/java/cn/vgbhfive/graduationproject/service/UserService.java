package cn.vgbhfive.graduationproject.service;

import cn.vgbhfive.graduationproject.entity.User;
import cn.vgbhfive.graduationproject.model.ReturnResult;
import cn.vgbhfive.graduationproject.repository.UserRepository;
import cn.vgbhfive.graduationproject.utils.EmailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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

}
