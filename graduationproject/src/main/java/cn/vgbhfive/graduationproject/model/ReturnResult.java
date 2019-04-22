package cn.vgbhfive.graduationproject.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 处理信息返回类
 *
 * @time: 2019/03/09
 * @author: Vgbh
 */
@Data
@ApiModel
public class ReturnResult {

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("封装数据")
    private Object data;

    @ApiModelProperty("报错信息")
    private String errorMsg;

    public ReturnResult() {
    }

    public static ReturnResult ok(Object data) {
        ReturnResult result = new ReturnResult();
        result.setCode(200);
        result.setData(data);
        result.setErrorMsg(null);
        return result;
    }

    public static ReturnResult error(Integer code, String errorMsg) {
        ReturnResult result = new ReturnResult();
        result.setCode(code);
        result.setData(null);
        result.setErrorMsg(errorMsg);
        return result;
    }

}
