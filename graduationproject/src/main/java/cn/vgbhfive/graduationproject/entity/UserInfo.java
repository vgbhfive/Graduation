package cn.vgbhfive.graduationproject.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户详细信息表
 *
 * @time: 2019/03/09
 * @author: Vgbh
 */
@Data
@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    private long userId; //用户ID

    private String idCard; //身份证

    private String phone; //手机

    private String email; //邮箱

    private Date registerDate; //注册时间

    private Date preUpdateDate; //上一次更新时间

    public UserInfo() {
    }

}
