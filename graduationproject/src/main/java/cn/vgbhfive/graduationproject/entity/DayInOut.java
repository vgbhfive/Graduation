package cn.vgbhfive.graduationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 日常收支表
 *
 * @time: 2019/03/09
 * @author: Vgbh
 */
@Data
@Entity
@Table(name = "day_income_expenditure")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@ApiModel
public class DayInOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dayId; //日常支出收入ID

    @ApiModelProperty("用户ID")
    private Long userId; //用户ID

    @ApiModelProperty("金额")
    private Integer money; //金额

    @ApiModelProperty("日期")
    private Date datetimes; //日期

    @ApiModelProperty("用途")
    private String howUse; //用途

    @ApiModelProperty("收入/支出")
    private Boolean income; //收入还是支出(True(1)/False(0))

    @ApiModelProperty("内容")
    private String contents; //内容

}
