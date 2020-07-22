package xyz.huanju.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author HuanJu
 * @date 2020/7/19 2:17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainConsul {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainConsul.class);
    }

}
