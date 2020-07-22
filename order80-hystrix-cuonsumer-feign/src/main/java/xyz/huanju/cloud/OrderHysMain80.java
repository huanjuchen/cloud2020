package xyz.huanju.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author HuanJu
 * @date 2020/7/21 2:30
 */
 @SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHysMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHysMain80.class);
    }
}
