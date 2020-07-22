package xyz.huanju.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author HuanJu
 * @date 2020/7/19 0:55
 */
@RestController
public class OrderZkController {

    public static final String INVOKER_URL="http://payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKER_URL+"/payment/zk",String.class);
    }




}
