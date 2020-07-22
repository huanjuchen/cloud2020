package xyz.huanju.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.huanju.cloud.domain.CommonResult;


/**
 * @author HuanJu
 * @date 2020/7/20 17:35
 */
//@Component
@FeignClient(value = "PAYMENT-PROVIDER")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String testTimeout();

}
