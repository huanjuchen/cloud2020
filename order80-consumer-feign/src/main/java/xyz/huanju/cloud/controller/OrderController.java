package xyz.huanju.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.huanju.cloud.domain.CommonResult;
import xyz.huanju.cloud.service.PaymentFeignService;

import javax.annotation.Resource;

/**
 * @author HuanJu
 * @date 2020/7/20 17:39
 */

@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String testTimeout(){
        return paymentFeignService.testTimeout();
    }


}
