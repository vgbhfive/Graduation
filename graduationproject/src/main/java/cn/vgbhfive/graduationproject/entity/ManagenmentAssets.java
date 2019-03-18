package cn.vgbhfive.graduationproject.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 个人财务管理表
 *
 * @time: 2019/03/09
 * @author: Vgbh
 */
@Data
@Entity
@Table(name = "management_assets")
public class ManagenmentAssets {

    @Id
    @GeneratedValue
    private long id; //ID

    private long userId; //用户ID

    private int money; //金额

    private Date date; //时间

    private int cycle; //周期(单位：月)

    private String property; //属性(黄金、工资、外汇、期权...)

    private String from; //来源(个人、理财...)

    private String content; //内容

    public ManagenmentAssets() {
    }
}
