package baseline.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

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
