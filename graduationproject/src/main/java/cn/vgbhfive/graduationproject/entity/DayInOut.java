package cn.vgbhfive.graduationproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class DayInOut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dayId; //日常支出收入ID

    private Long userId; //用户ID

    private Integer money; //金额

    private Date datetimes; //日期

    private String howUse; //用途

    private Boolean income; //收入还是支出(True(1)/False(0))

    private String contents; //内容

}
