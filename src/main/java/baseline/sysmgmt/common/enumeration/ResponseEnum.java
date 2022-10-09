package baseline.sysmgmt.common.enumeration;


/**
 * @author:crelle
 * @className:ResponseEnum
 * @version:1.0.0
 * @date:2021/3/23
 * @description:XX
 **/
public enum ResponseEnum {
    SUCCESS("00000", "成功"), FAIL("-1", "失败");

    private String code;
    private String name;

    ResponseEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
