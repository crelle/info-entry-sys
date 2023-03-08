package baseline.common.util;

import baseline.common.exception.BusinessException;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static baseline.common.util.CommonUtils.date2Str;

public class FileUtil {
    // 新版Excel文件后缀
    private static final String EXCEL_SUFFIX = ".xlsx";


    /**
     * 判断文件大小
     *
     * @param len  文件长度
     * @param size 限制大小
     * @param unit 限制单位（B,K,M,G）
     * @return
     */
    public static boolean checkFileSize(Long len, int size, String unit) {
//        long len = file.length();
        double fileSize = 0;
        if ("B".equals(unit.toUpperCase())) {
            fileSize = (double) len;
        } else if ("K".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1024;
        } else if ("M".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1048576;
        } else if ("G".equals(unit.toUpperCase())) {
            fileSize = (double) len / 1073741824;
        }
        if (fileSize > size) {
            return false;
        }
        return true;
    }


    public static void downLoadFile(String filePath, String fileName, HttpServletResponse response) {
        try (InputStream inStream = new FileInputStream(filePath);
             OutputStream os = response.getOutputStream()) {
            response.setHeader("Content-Disposition", "attachment; fileName=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            byte[] buff = new byte[100];
            int len;
            while ((len = inStream.read(buff)) > 0) {
                os.write(buff, 0, len);
            }
            os.flush();
        } catch (Exception e) {
            throw new BusinessException("下载文件失败");
        }
    }

    //下载模板
    public static void downloadExcel(HttpServletRequest request, HttpServletResponse response) {
        //方法一：直接下载路径下的文件模板（这种方式貌似在SpringCloud和Springboot中，打包成JAR包时，无法读取到指定路径下面的文件，不知道记错没，你们可以自己尝试下！！！）
        try {
            //文件名称
            String fileName = "importStaffRoster.xlsx";
            //设置要下载的文件的名称
            response.setHeader("Content-disposition", "attachment;fileName=" + fileName);
            //通知客服文件的MIME类型
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            //获取文件的路径
            String filePath = FileUtil.class.getResource("/template/" + fileName).getPath();
            FileInputStream input = new FileInputStream(filePath);
            OutputStream out = response.getOutputStream();
            byte[] b = new byte[2048];
            int len;
            while ((len = input.read(b)) != -1) {
                out.write(b, 0, len);
            }
            //修正 Excel在“xxx.xlsx”中发现不可读取的内容。是否恢复此工作薄的内容？如果信任此工作簿的来源，请点击"是"
            response.setHeader("Content-Length", String.valueOf(input.getChannel().size()));
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 导出核心实现
     *
     * @param fileName
     * @param headers
     * @param dataList
     * @return XSSFWorkbook
     */
    public static XSSFWorkbook writeDataToWorkbook(String fileName, List<String> headers, List<Map<String, Object>> dataList) {
        // 创建一个工作薄
        XSSFWorkbook workbook = new XSSFWorkbook();
        try {
            // 创建一个工作表
            XSSFSheet sheet = workbook.createSheet(fileName);

            //合并单元格  参数1：起始行 参数2：终止行 参数3：起始列 参数4：终止列
            CellRangeAddress region1 = new CellRangeAddress(0, 0, (short) 0, (short) 11);
            sheet.addMergedRegion(region1);

            //表头字体
            XSSFFont firstRow = workbook.createFont();
            firstRow.setFontName("宋体");
            firstRow.setColor(IndexedColors.DARK_GREEN.index);
            firstRow.setFontHeightInPoints((short) 20);
            firstRow.setBold(true);
            firstRow.setBold(true);

            //表头格式
            XSSFCellStyle firstRowStyle = workbook.createCellStyle();
            //设置水平对齐方式
            firstRowStyle.setAlignment(HorizontalAlignment.CENTER);
            firstRowStyle.setAlignment(HorizontalAlignment.CENTER);
            //边框样式
            //设置上边框线条类型
            firstRowStyle.setBorderTop(BorderStyle.THIN);
            //设置右边框线条类型
            firstRowStyle.setBorderRight(BorderStyle.THIN);
            //设置下边框线条类型
            firstRowStyle.setBorderBottom(BorderStyle.THIN);
            //设置左边框线条类型
            firstRowStyle.setBorderLeft(BorderStyle.THIN);
            //设置上边框线条颜色
            firstRowStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
            //设置右边框线条颜色
            firstRowStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
            //设置下边框线条颜色
            firstRowStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            //设置左边框线条颜色
            firstRowStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            firstRowStyle.setFont(firstRow);

            //表头信息
            int index = 0;
            XSSFRow row = sheet.createRow(index);
            XSSFCell cell = row.createCell(0);
            cell.setCellStyle(firstRowStyle);
            XSSFRichTextString text = new XSSFRichTextString(fileName);
            cell.setCellValue(text);


            // 设置表头字体格式
            XSSFFont headersFont = workbook.createFont();
            headersFont.setFontName("宋体");
            headersFont.setColor(IndexedColors.DARK_GREEN.index);
            headersFont.setFontHeightInPoints((short) 14);
            headersFont.setBold(true);

            // 设置正文字体格式
            XSSFFont dataSetFont = workbook.createFont();
            dataSetFont.setFontName("宋体");
            dataSetFont.setColor(IndexedColors.BLACK.index);
            dataSetFont.setBold(false);

            // 此处设置数据格式
            XSSFDataFormat df = workbook.createDataFormat();

            // 创建表头样式
            XSSFCellStyle headersStyle = workbook.createCellStyle();
            headersStyle.setBorderTop(BorderStyle.THIN);
            headersStyle.setBorderBottom(BorderStyle.THIN);
            headersStyle.setBorderLeft(BorderStyle.THIN);
            headersStyle.setBorderRight(BorderStyle.THIN);
            headersStyle.setFont(headersFont);
            // 表头内容对齐方式：居中
            headersStyle.setAlignment(HorizontalAlignment.CENTER);

            // 创建文本样式
            XSSFCellStyle textStyle = workbook.createCellStyle();
            textStyle.setFont(dataSetFont);
            // 数据内容对齐方式：居左
            textStyle.setAlignment(HorizontalAlignment.RIGHT);

            // 创建浮点型数字样式
            XSSFCellStyle floatStyle = workbook.createCellStyle();
            floatStyle.setAlignment(HorizontalAlignment.RIGHT);
            floatStyle.setFont(dataSetFont);
            floatStyle.setDataFormat(df.getFormat("#,##0.00"));

            // 创建整型数字样式
            XSSFCellStyle integerStyle = workbook.createCellStyle();
            integerStyle.setAlignment(HorizontalAlignment.RIGHT);
            integerStyle.setFont(dataSetFont);
            integerStyle.setDataFormat(df.getFormat("0"));

            index++;
            row = sheet.createRow(index);
            for (int i = 0; i < headers.size(); i++) {
                sheet.setColumnWidth(i, 20 * 256);
                cell = row.createCell(i);
                cell.setCellStyle(headersStyle);
                XSSFRichTextString xssfRichTextString = new XSSFRichTextString(headers.get(i));
                cell.setCellValue(xssfRichTextString);
            }
            // 导出正文数据，并设置其样式
            for (Map<String, Object> data : dataList) {
                index++;
                row = sheet.createRow(index);
                int column = 0;
                for (String key : data.keySet()) {
                    cell = row.createCell(column++);
                    Object value = data.get(key);
                    if (value == null) {
                        continue;
                    }

                    String dataType = value.getClass().getName();
                    if (dataType.endsWith("BigDecimal") || dataType.endsWith("Double") || dataType.endsWith("Float")) {
                        cell.setCellStyle(floatStyle);  // 带小数点的数字格式
                        cell.setCellValue(Double.parseDouble(value.toString()));
                    } else if (dataType.endsWith("Integer") || dataType.endsWith("Long")) {
                        cell.setCellStyle(integerStyle);    // 整型数字格式
                        cell.setCellValue(Double.parseDouble(value.toString()));
                    } else if (dataType.endsWith("Date")) {
                        cell.setCellStyle(textStyle);   //日期转为字符串
                        cell.setCellValue(date2Str((Date) value, "yyyy-MM-dd"));
                    } else {
                        cell.setCellStyle(textStyle);   // 文本格式
                        cell.setCellValue(value.toString());
                    }
                }
            }
        } catch (Exception e) {
            throw new BusinessException("writeDataToWorkbook error, ", e.getMessage());
        }
        return workbook;
    }


}

