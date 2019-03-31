package cn.vgbhfive.graduationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 个人财务管理表
 *
 * @time: 2019/03/09
 * @author: Vgbh
 */
@Data
@Entity
@Table(name = "man_asset")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ManAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //ID

    private Long userId; //用户ID

    @NotNull
    private Integer money; //金额

    private Date datetimes; //时间

    private Integer cycle; //周期(单位：月)

    private String property; //属性(黄金、工资、外汇、期权...)

    private String source; //来源(个人、理财...)

    private String contents; //内容

}
