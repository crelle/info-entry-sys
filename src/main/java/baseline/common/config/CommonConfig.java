package baseline.common.config;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CommonConfig {

    @Autowired
    private ConfigProperties configProperties;

//    @Bean
//    public MyFtpClient ftpService() {
//        String server = configProperties.getConfigValue("ftp.ip");
//        int port = Integer.valueOf(configProperties.getConfigValue("ftp.port"));
//        String user = configProperties.getConfigValue("ftp.username");
//        String password = configProperties.getConfigValue("ftp.password");
//        int activeMinPort = Integer.valueOf(configProperties.getConfigValue("ftp.active.min.port"));
//        int activeMaxPort = Integer.valueOf(configProperties.getConfigValue("ftp.active.max.port"));
//        return new MyFtpClient(server, port, user, password, activeMinPort, activeMaxPort);
//    }
}
