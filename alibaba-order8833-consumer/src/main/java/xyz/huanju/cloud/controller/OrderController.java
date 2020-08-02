package xyz.huanju.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author HuanJu
 * @date 2020/7/28 20:54
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${server-url.payment-service}")
    private String paymentServiceUrl;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String doSomething(@PathVariable("id") Integer id){
        return restTemplate.getForObject(paymentServiceUrl+"/payment/nacos/"+id,String.class);
    }


}
