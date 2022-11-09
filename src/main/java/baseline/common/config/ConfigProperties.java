package baseline.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author:crelle
 * @className:ConfigProperties
 * @version:1.0.0
 * @date:2021/4/26
 * @description:根据key获取配置文件里的value
 **/
@Component
@PropertySource("classpath:application.properties")
public class ConfigProperties {
    @Autowired
    private Environment env;

    public String getConfigValue(String configKey){
        return env.getProperty(configKey);
    }
}
