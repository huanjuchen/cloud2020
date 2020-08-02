package xyz.huanju.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author HuanJu
 * @date 2020/7/30 17:37
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceMain.class);
    }

}
