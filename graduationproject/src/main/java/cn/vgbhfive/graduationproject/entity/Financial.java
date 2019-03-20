package cn.vgbhfive.graduationproject.entity;

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
public class Financial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //理财ID

    private String name; //名称

    private Integer deadline; //期限(单位：月)

    private Integer money; //购买金额

    private Float intrates; //利率

    private Float expectReturn; //预计收益

    private String content; //内容

}
