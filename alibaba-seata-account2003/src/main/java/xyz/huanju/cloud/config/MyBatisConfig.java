package xyz.huanju.cloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuanJu
 * @date 2020/8/3 20:04
 */
@Configuration
@MapperScan({"xyz.huanju.cloud.dao"})
public class MyBatisConfig {
}
