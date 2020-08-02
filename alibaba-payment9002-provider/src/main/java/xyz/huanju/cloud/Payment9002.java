package xyz.huanju.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author HuanJu
 * @date 2020/7/28 20:32
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9002 {

    public static void main(String[] args) {
        SpringApplication.run(Payment9002.class);
    }

}
