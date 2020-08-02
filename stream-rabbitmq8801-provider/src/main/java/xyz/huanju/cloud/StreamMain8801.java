package xyz.huanju.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author HuanJu
 * @date 2020/7/24 0:15
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMain8801.class);
    }

}
