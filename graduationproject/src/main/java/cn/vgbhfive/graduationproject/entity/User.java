package cn.vgbhfive.graduationproject.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 用户表
 *
 * @time: 2019/1/30
 * @author: Vgbh
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //用户ID

    private String username; //用户名

    private String password; //密码

    private String role; //权限

}
