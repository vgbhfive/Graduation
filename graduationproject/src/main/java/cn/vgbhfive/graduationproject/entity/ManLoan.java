package cn.vgbhfive.graduationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class ManLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manloanId; //贷款ID

    private Long userId; //用户ID

    private Integer money; //金额

    private String type; //类型

    private Date datetimes; //时间

    private Integer deadline; //期限(单位：月)

    private Float intrate; //利率

    private String contents; //内容

}
