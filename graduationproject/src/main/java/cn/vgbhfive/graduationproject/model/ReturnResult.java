package cn.vgbhfive.graduationproject.model;

import lombok.Data;

/**
 * 处理信息返回类
 *
 * @time: 2019/03/09
 * @author: Vgbh
 */
@Data
public class ReturnResult {

    private Integer code;

    private Object data;

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
