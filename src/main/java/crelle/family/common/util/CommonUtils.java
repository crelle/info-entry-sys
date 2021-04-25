package crelle.family.common.util;

import org.apache.commons.lang3.text.StrBuilder;

import java.util.Calendar;
import java.util.UUID;

/**
 * @author:crelle
 * @className:CommonUtils
 * @version:1.0.0
 * @date:2021/4/25
 * @description:XX
 **/
public abstract class CommonUtils {

    /**
     *@author:crelle
     *@date:2021/4/25
     *@title:generateMediaName
     *@description:生成媒体资源的名字
     *@params:[preFix, mediaType]
     *@return:java.lang.String
     *@throw:
     */
    public static String generateMediaName(String prefix, String mediaType) {
        StringBuffer stringBuffer = new StringBuffer();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        stringBuffer.append(prefix).append(year+"-").append(month+"-").append(day+"-").append(UUID.randomUUID()).append("."+mediaType);
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

}
