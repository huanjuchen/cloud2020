package xyz.huanju.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuanJu
 * @date 2020/7/28 20:27
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String doSomething(@PathVariable("id") Integer id){
        return "Nacos Services Provider, ServerPort: "+serverPort+", id: "+id;
    }


}
