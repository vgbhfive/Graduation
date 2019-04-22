package cn.vgbhfive.graduationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * 贷款信息表
 *
 * @time: 2019/03/09
 * @author: Vgbh
 */
@Data
@Entity
@Table(name = "loan")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@ApiModel
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId; //贷款ID

    @ApiModelProperty("金额")
    private Integer money; //金额

    @ApiModelProperty("期限")
    private Integer returnDate; //归还时间(单位:月)

    @ApiModelProperty("类型")
    private String type; //类型

    @ApiModelProperty("利率")
    private Float intrate; //利率

    @ApiModelProperty("赔率")
    private Float odds; //赔率

    @ApiModelProperty("内容")
    private String contents; //内容

}
