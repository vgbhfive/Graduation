package cn.vgbhfive.graduationproject.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

/**
 * 个人贷款管理表
 *
 * @time: 2019/03/09
 * @author: Vgbh
 */
@Data
@Entity
@Table(name = "man_loan")
public class ManLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manloanId; //贷款ID

    private Long userId; //用户ID

    private Integer money; //金额

    private String type; //类型

    private Date date; //时间

    private Integer deadline; //期限(单位：月)

    private Float intrate; //利率

    private String content; //内容

}
