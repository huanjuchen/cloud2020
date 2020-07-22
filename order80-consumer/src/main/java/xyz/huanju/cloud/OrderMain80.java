package xyz.huanju.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
//import xyz.huanju.ribbon.rule.CustomRule;

/**
 * @author HuanJu
 * @date 2020/7/11 16:01
 */
@EnableEurekaClient
@SpringBootApplication
//定义某个服务的负载均衡算法为自定义
//name必须大写
//@RibbonClient(name = "PAYMENT-PROVIDER",configuration = CustomRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class);
    }
}
