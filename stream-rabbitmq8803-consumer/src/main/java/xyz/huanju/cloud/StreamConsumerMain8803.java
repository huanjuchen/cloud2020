package xyz.huanju.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author HuanJu
 * @date 2020/7/24 23:50
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamConsumerMain8803 {

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerMain8803.class);
    }
}
