package crelle.family;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Calendar;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author:crelle
 * @className:Test1
 * @version:1.0.0
 * @date:2021/4/22
 * @description:XX
 **/
public class Test1 {

    @Test
    public void test1() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword1 = passwordEncoder.encode("admin");
        String encodedPassword2 = passwordEncoder.encode("user");
        String encodedPassword3 = passwordEncoder.encode("guest");

        System.out.println("1:" + encodedPassword1);
        System.out.println("2:" + encodedPassword2);
        System.out.println("3:" + encodedPassword3);
    }

    @Test
    public void test2() {
        StringBuffer stringBuffer = new StringBuffer();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        stringBuffer.append("/dataftp/fes/picture/").append(year + "-").append(month + "-").append(day + "-").append(UUID.randomUUID()).append("." + "png");
        System.out.println(stringBuffer.toString());
        System.out.println(stringBuffer.toString());
    }


    @Test
    public void testpatternStr() {
        String employee = "专科";
        String patternStr = "^[专|本|硕士|博士].+[研究生|科]{0,1}$";
        boolean matcher = getMatcher(employee, patternStr);
        System.out.println(matcher);
    }

    private static boolean getMatcher(String employee, String patternStr) {
        //一个Pattern对象和一个正则表达式相关联
        Pattern pattern = Pattern.compile(patternStr);
        //一个Matcher对象和一个具体的字符串相关联，表示在指定模式下与这个字符串匹配
        Matcher matcher = pattern.matcher(employee);
        // 匹配返回true
        return matcher.matches();
    }


    @Test
    public void testpatternSt2() {
        int intNum = getIntNum("111111.0");
        System.out.println(intNum);
    }


    private int getIntNum(String str){
        //字符串去掉小数点后取整数
        if(str.contains(".")) {
            int indexOf = str.indexOf(".");
            str = str.substring(0, indexOf);
        }
        return Integer.parseInt(str);
    }
}
