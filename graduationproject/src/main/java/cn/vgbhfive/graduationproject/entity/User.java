package cn.vgbhfive.graduationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@ApiModel
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //用户ID

    @ApiModelProperty("用户名")
    private String username; //用户名

    @ApiModelProperty("密码")
    private String password; //密码

    @ApiModelProperty("权限")
    private String role; //权限

}
