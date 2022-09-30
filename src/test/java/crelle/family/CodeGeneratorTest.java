package crelle.family;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

/**
 * myBaties plus代码生成器
 */
public class CodeGeneratorTest {

    private String date;
    private final String basePath = "D://coding//info-entry-sys//src//main";
    private final String url = "jdbc:mysql://127.0.0.1:3306/archermind-system-db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private final String username = "root";
    private final String password = "123456";
    private final String author = "crelle";

    @Before
    public void before() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = simpleDateFormat.format(new Date());
    }


    @Test
    public void test() {
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者
                            .commentDate(date)
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(basePath); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("//java//crelle.family") // 设置父包名
                            .moduleName("sys") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, basePath + "//resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("test") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
