package xyz.huanju.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author HuanJu
 * @date 2020/7/19 2:08
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @RequestMapping(value = "/payment/consul")
    public String paymentConsul(){
        return "Spring Cloud with Consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
