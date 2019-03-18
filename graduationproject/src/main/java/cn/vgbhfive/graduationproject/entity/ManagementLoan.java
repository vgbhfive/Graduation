package cn.vgbhfive.graduationproject.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 个人贷款管理表
 *
 * @time: 2019/03/09
 * @author: Vgbh
 */
@Data
@Entity
@Table(name = "management_loan")
public class ManagementLoan {

    @Id
    @GeneratedValue
    private Long loanId; //贷款ID

    private long userId; //用户ID

    private int money; //金额

    private String type; //类型

    private Date date; //时间

    private int returnTime; //返还时间(单位：月)

    private float intrate; //利率

    private String content; //内容

    public ManagementLoan() {
    }
}
