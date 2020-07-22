package xyz.huanju.cloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import xyz.huanju.cloud.domain.CommonResult;
import xyz.huanju.cloud.domain.Payment;
import xyz.huanju.cloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author HuanJu
 * @date 2020/7/11 15:14
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping(value = "/payment")
    public CommonResult save(@RequestBody Payment payment) {
        int result = paymentService.save(payment);
//        int a=1+1;
        log.info("Created Result: " + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功, serverPort=" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败, serverPort=" + serverPort);
        }
    }

    @GetMapping("/payment/{id}")
    public CommonResult getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果: " + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功, serverPort=" + serverPort, payment);
        } else {
            return new CommonResult(444, "查询失败, serverPort=" + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


    /**
     * 用于模拟Feign调用超时
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentStringTimeout(){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPort;
    }


    @GetMapping(value = "/payment/discovery")
    public Object discovery() {

        List<String> services = discoveryClient.getServices();

        for (String element : services) {
            log.info("*****element: " + element);
        }


        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-PROVIDER");

        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }




}
