package xyz.huanju.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.huanju.cloud.domain.CommonResult;
import xyz.huanju.cloud.domain.Payment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HuanJu
 * @date 2020/8/2 1:31
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    public static Map<Long, Payment> map=new HashMap<>();


    //用于模拟数据库
    static{
        map.put(1L,new Payment(1L,"Serial01"));
        map.put(2L,new Payment(2L,"Serial02"));
        map.put(3L,new Payment(3L,"Serial03"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult paymentSQL(@PathVariable("id") Long id){
        Payment payment=map.get(id);

        return new CommonResult(200,"From MySQL, Server Port: "+serverPort,payment);
    }



}
