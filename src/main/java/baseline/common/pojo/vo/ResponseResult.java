package baseline.common.pojo.vo;

import baseline.common.enumeration.ResponseEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author:crelle
 * @className:ResponseResult
 * @version:1.0.0
 * @date:2021/3/23
 * @description:XX
 **/
@ApiModel(value = "ResponseResult", description = "统一返回VO")
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "返回码")
    private String code;

    @ApiModelProperty(value = "返回信息")
    private String message;

    @ApiModelProperty(value = "返回实体")
    private T data;

    @ApiModelProperty(value = "统计data中的数据总条数,不用于分页,分页中的总条数从data中获取")
    private long total;

    public ResponseResult() {
        this(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage());
    }

    public ResponseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseResult ok() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(ResponseEnum.SUCCESS.getCode());
        responseResult.setMessage(ResponseEnum.SUCCESS.getMessage());
        return responseResult;
    }

    public static ResponseResult ok(String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(ResponseEnum.SUCCESS.getCode());
        responseResult.setMessage(message);
        return responseResult;
    }

    public static ResponseResult fail() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(ResponseEnum.FAIL.getCode());
        responseResult.setMessage(ResponseEnum.FAIL.getMessage());
        return responseResult;
    }

    public static ResponseResult fail(String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(ResponseEnum.FAIL.getCode());
        responseResult.setMessage(message);
        return responseResult;
    }

    public static ResponseResult fail(String code, String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(code);
        responseResult.setMessage(message);
        return responseResult;
    }

    public void buildFail(String message) {
        this.setCode(ResponseEnum.FAIL.getCode());
        this.setMessage(message);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", total=" + total +
                '}';
    }
}
