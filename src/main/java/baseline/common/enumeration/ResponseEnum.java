package baseline.common.enumeration;


/**
 * @author:crelle
 * @className:ResponseEnum
 * @version:1.0.0
 * @date:2021/3/23
 * @description:XX
 **/
public enum ResponseEnum {
    FAIL("-1", "失败"),
    SUCCESS("00000", "成功"),
    UNKNOWN("00001", "服务器发生未知异常，请联系管理员处理！"),
    BAD_REQUEST("400", "请求数据格式非法。"),
    FORBIDDEN("403", "没有访问权限!"),
    NO_RESOURCE("404", "请求的资源找不到!"),
    SERVER_ERROR("500", "服务器内部错误!"),
    SERVICE_BUSY("503", "服务器正忙，请稍后再试!");
    private String code;
    private String message;

    ResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
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
    }}
