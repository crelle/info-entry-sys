package crelle.family;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Calendar;
import java.util.UUID;

/**
 * @author:crelle
 * @className:Test1
 * @version:1.0.0
 * @date:2021/4/22
 * @description:XX
 **/
public class Test1 {

    @Test
    public void test1(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword1 = passwordEncoder.encode("admin");
        String encodedPassword2 = passwordEncoder.encode("user");
        String encodedPassword3 = passwordEncoder.encode("guest");

        System.out.println("1:"+encodedPassword1);
        System.out.println("2:"+encodedPassword2);
        System.out.println("3:"+encodedPassword3);
    }

    @Test
    public void test2(){
        StringBuffer stringBuffer = new StringBuffer();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        stringBuffer.append("/dataftp/fes/picture/").append(year+"-").append(month+"-").append(day+"-").append(UUID.randomUUID()).append("."+"png");
        System.out.println(stringBuffer.toString());
        System.out.println(stringBuffer.toString());
    }
}
