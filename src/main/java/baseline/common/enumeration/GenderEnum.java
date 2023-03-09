package baseline.common.enumeration;

/**
 * @author ZhangJin
 * @create 2023-02-27 19:33
 */
public enum  GenderEnum {
    //定义枚举类型的变量(所有定义的变量都是当前枚举类型的实例名)
    //默认所有的定义变量，都是public static final 类型，不需要手动声明，而且一般都是大写
    MAN("男"),
    WOMAN("女");

    private String value;

    GenderEnum(String value) {
        this.value = value;
    }

    public String getValue(){
        return  value;
    }
}
