package crelle.family;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * myBaties plus代码生成器
 */
public class CodeGeneratorTest {

    //项目目录
    private final String basePath = System.getProperty("user.dir");
    //模块名
    //TODO
    private final String parentModuleName = "sysmgmt";
    //文件作者
    private final String author = "crelle";
    //数据库url
    private final String url = "jdbc:mysql://139.196.125.106:3306/archermind-system-db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    //    private final String url = "jdbc:mysql://127.0.0.1:3306/archermind-system-db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    //数据库用户名
    private final String username = "crelle";
    //    private final String username = "root";
    //数据库密码
    private final String password = "crelle@123";
//    private final String password = "123456";


    @Test
    public void test() {
        //1、配置数据源
        FastAutoGenerator.create(url, username, password)
                //2、全局配置
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者名
                            .outputDir(basePath + "/src/main/java")   //设置输出路径
                            .commentDate("yyyy-MM-dd hh:mm:ss")   //注释日期
                            .dateType(DateType.ONLY_DATE)   //定义生成的实体类中日期的类型 TIME_PACK=LocalDateTime;ONLY_DATE=Date;
//                            .fileOverride()   //覆盖之前的文件
                            .enableSwagger()   //开启 swagger 模式
                            .disableOpenDir();   //禁止打开输出目录，默认打开
                })
                //3、包配置
                .packageConfig(builder -> {
                    builder.parent("temp") // 设置父包名
                            .moduleName(parentModuleName)   //设置模块包名
                            .entity("pojo.entity")   //pojo 实体类包名
                            .service("service") //Service 包名
                            .serviceImpl("service.impl") // ***ServiceImpl 包名
                            .mapper("mapper")   //Mapper 包名
                            .xml("mapper")  //Mapper XML 包名
                            .controller("controller") //Controller 包名
                            .other("common") //自定义文件包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, basePath + "/src/main/resources/mapper"));    //配置 **Mapper.xml 路径信息：项目的 resources 目录的 Mapper 目录下
                })
                //4、策略配置
                .strategyConfig(builder -> {
                    //TODO
                    builder.addInclude("t_customer",
                            "t_department",
                            "t_region",
                            "t_contact_person",
                            "t_contact_person_project",
                            "t_project",
                            "t_post",
                            "t_employee",
                            "t_asset",
                            "t_status_record",
                            "t_communicate") // 设置需要生成的数据表名
                            .addTablePrefix("t_", "c_") // 设置过滤表前缀
                            //4.1、Mapper策略配置
                            .mapperBuilder()
                            .superClass(BaseMapper.class)   //设置父类
                            .formatMapperFileName("%sMapper")   //格式化 mapper 文件名称
                            .enableMapperAnnotation()       //开启 @Mapper 注解
                            .formatXmlFileName("%sMapper") //格式化 Xml 文件名称

                            //4.2、service 策略配置
                            .serviceBuilder()
                            .formatServiceFileName("%sService") //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                            .formatServiceImplFileName("%sServiceImpl") //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl

                            //4.4、Controller策略配置
                            .controllerBuilder()
                            .formatFileName("%sController") //格式化 Controller 类文件名称，%s进行匹配表名，如 UserController
                            .enableRestStyle() //开启生成 @RestController 控制器

                            //4.3、实体类策略配置
                            .entityBuilder()
                            .enableLombok() //开启 Lombok
                            .disableSerialVersionUID()  //不实现 Serializable 接口，不生产 SerialVersionUID
                            .idType(IdType.ASSIGN_UUID)
                            .logicDeleteColumnName("deleted")   //逻辑删除字段名
                            .naming(NamingStrategy.underline_to_camel)  //数据库表映射到实体的命名策略：下划线转驼峰命
                            .columnNaming(NamingStrategy.underline_to_camel)    //数据库表字段映射到实体的命名策略：下划线转驼峰命
                            .addTableFills(
                                    new Column("create_time", FieldFill.INSERT),
                                    new Column("modify_time", FieldFill.INSERT_UPDATE)
                            )   //添加表字段填充，"create_time"字段自动填充为插入时间，"modify_time"字段自动填充为插入修改时间
                            .enableTableFieldAnnotation();      // 开启生成实体时生成字段注解

                })
                .templateEngine(new FreemarkerTemplateEngine()) //使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
