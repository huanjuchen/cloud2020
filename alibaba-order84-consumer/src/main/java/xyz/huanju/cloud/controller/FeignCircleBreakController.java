package xyz.huanju.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.huanju.cloud.domain.CommonResult;
import xyz.huanju.cloud.feign.PaymentService;

import javax.annotation.Resource;

/**
 * @author HuanJu
 * @date 2020/8/2 16:36
 */
@RestController
@Slf4j
public class FeignCircleBreakController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/feign/paymentSQL/{id}")
    public CommonResult paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }

}
