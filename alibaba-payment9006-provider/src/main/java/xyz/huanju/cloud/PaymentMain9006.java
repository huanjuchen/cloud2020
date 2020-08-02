package xyz.huanju.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author HuanJu
 * @date 2020/8/2 1:30
 */

@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain9006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9006.class);
    }
}
