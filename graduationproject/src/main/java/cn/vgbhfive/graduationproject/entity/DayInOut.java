package cn.vgbhfive.graduationproject.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
public class DayInOut {

    @Id
    @GeneratedValue
    private long dayId; //日常支出收入ID

    private long userId; //用户ID

    private int money; //金额

    private Date date; //日期

    private String howUse; //用途

    private boolean income; //收入还是支出

    private String content; //内容

    public DayInOut() {
    }
}
