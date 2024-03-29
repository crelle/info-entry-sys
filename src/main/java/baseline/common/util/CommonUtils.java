package baseline.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
     * @author:crelle
     * @date:2021/4/25
     * @title:generateMediaName
     * @description:生成相对媒体资源名字 prefix/YEAR-MONTH-DAY_OF_MONTH-randomUUID.suffix
     * @params:[preFix, mediaType]
     * @return:java.lang.String
     * @throw:
     */
    public static String generateRelativeMediaResourcesUri(String prefix, String suffix) {
        StringBuffer stringBuffer = new StringBuffer();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        stringBuffer.append(prefix).append(year + "-").append(month + "-").append(day + "-").append(UUID.randomUUID()).append("." + suffix);
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

    public static String getFileSuffixFromMultipartFile(MultipartFile multipartFile) throws Exception {

        String originalFilename = multipartFile.getOriginalFilename();
        if (StringUtils.isBlank(originalFilename)) {
            throw new Exception("文件名为空");
        }
        //正则匹配
        String[] StringArr = originalFilename.split("\\.");
        if (StringArr.length <= 0) {
            throw new Exception("文件后缀为空！");
        }
        return StringArr[StringArr.length - 1];
    }

    public static Date transferString2Date(String s) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(s);
        } catch (ParseException e) {
            //LOGGER.error("时间转换错误, string = {}", s, e);
        }
        return date;
    }

    public static String date2Str(Date date, String pattern) {
        if (null == date) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

}
