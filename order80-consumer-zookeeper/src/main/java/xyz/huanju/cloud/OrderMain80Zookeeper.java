package xyz.huanju.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author HuanJu
 * @date 2020/7/19 0:53
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrderMain80Zookeeper {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80Zookeeper.class);
    }
}
