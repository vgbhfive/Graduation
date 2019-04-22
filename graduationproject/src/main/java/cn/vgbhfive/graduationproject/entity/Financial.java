package cn.vgbhfive.graduationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * 理财信息表
 *
 * @time: 2019/03/09
 * @author: Vgbh
 */
@Data
@Entity
@Table(name = "financial")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@ApiModel
public class Financial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //理财ID

    @ApiModelProperty("名称")
    private String name; //名称

    @ApiModelProperty("期限")
    private Integer deadline; //期限(单位：月)

    @ApiModelProperty("金额")
    private Integer money; //购买金额

    @ApiModelProperty("利率")
    private Float intrates; //利率

    @ApiModelProperty("收益")
    private Float expectReturn; //预计收益

    @ApiModelProperty("内容")
    private String contents; //内容

}
