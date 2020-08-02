package xyz.huanju.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author HuanJu
 * @date 2020/7/28 20:25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9003 {

    public static void main(String[] args) {
        SpringApplication.run(Payment9003.class);
    }


}
