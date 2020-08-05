package xyz.huanju.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author HuanJu
 * @date 2020/8/4 1:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StorageMain2002 {

    public static void main(String[] args) {
        SpringApplication.run(StorageMain2002.class);
    }

}
