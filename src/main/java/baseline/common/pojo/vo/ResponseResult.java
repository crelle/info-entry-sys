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

    @ApiModelProperty(value = "总条数")
    private long total;

    public ResponseResult() {
        this(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getName());
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

    public void buildFail() {
        this.code = ResponseEnum.FAIL.getCode();
        this.message = ResponseEnum.FAIL.getName();
    }

    public void buildFail(String message) {
        this.code = ResponseEnum.FAIL.getCode();
        this.message = message;
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
