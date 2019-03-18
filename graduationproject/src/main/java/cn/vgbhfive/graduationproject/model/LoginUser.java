package cn.vgbhfive.graduationproject.model;

import lombok.Data;

/**
 * 用户登录信息中间表
 *
 * @time: 2019/03/04
 * @author: Vgbh
 */
@Data
public class LoginUser {

    private String username;

    private String password;

    private Integer rememberMe;

}
