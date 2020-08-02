package xyz.huanju.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author HuanJu
 * @date 2020/7/24 15:48
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamConsumerMain8802 {

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerMain8802.class);
    }

}
