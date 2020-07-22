package xyz.huanju.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuanJu
 * @date 2020/7/20 18:10
 */
@Configuration
public class FeignConfig {


    /**
     * 配置Feign日志级别
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
