package baseline.common.util;

import baseline.common.ResponseResult;
import baseline.common.enumeration.ResponseEnum;

/**
 * @author:crelle
 * @className:ResultUtils
 * @version:1.0.0
 * @date:2021/3/24
 * @description:XX
 **/
public class ResultUtils {


    public ResultUtils() {
    }

    public static <T> ResponseResult<T> build() {
        return new ResponseResult();
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getName(), null);
    }

    public static <T> ResponseResult<T> success(String message) {
        return new ResponseResult(ResponseEnum.SUCCESS.getCode(), message, null);
    }

    public static <T> ResponseResult<T> success(String message, T data) {
        return new ResponseResult(ResponseEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> ResponseResult<T> fail() {
        return new ResponseResult(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getName(), null);
    }

    public static <T> ResponseResult fail(String message) {
        return new ResponseResult(ResponseEnum.FAIL.getCode(), message, null);
    }

    public static <T> ResponseResult fail(String message, Object data) {
        return new ResponseResult(ResponseEnum.FAIL.getCode(), message, data);
    }

}
