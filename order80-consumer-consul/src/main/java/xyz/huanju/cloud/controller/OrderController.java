package xyz.huanju.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author HuanJu
 * @date 2020/7/19 2:19
 */
@RestController
public class OrderController {

    public static final String INVOKER_URL="http://payment-provider-consul";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo(){
        return restTemplate.getForObject(INVOKER_URL+"/payment/consul",String.class);
    }




}
