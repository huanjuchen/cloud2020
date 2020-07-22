package xyz.huanju.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author HuanJu
 * @date 2020/7/20 17:32
 */
@SpringBootApplication
//启用Feign
@EnableFeignClients
@EnableEurekaClient
public class OrderMainFeign {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainFeign.class);
    }

}
