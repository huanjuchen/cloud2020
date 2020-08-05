package xyz.huanju.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author HuanJu
 * @date 2020/8/4 3:10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AccountMain2003 {

    public static void main(String[] args) {
        SpringApplication.run(AccountMain2003.class);
    }
}
