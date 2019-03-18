package cn.vgbhfive.graduationproject.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 贷款信息表
 *
 * @time: 2019/03/09
 * @author: Vgbh
 */
@Data
@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue
    private Long loanId; //贷款ID

    private Integer money; //金额

    private Integer returnDate; //归还时间(单位:月)

    private String type; //类型

    private Float intrate; //利率

    private Float odds; //赔率

    private String content; //内容

}
