package plant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan(basePackages = "plant.mapper")
public class SysApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysApplication.class, args);
    }

}
