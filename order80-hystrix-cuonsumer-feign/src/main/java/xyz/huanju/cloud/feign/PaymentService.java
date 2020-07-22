package xyz.huanju.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.huanju.cloud.feign.impl.PaymentFallBackService;

/**
 * @author HuanJu
 * @date 2020/7/21 2:31
 */
//Feign 服务降级
@FeignClient(value = "PAYMENT-HYSTRIX-PROVIDER",fallback = PaymentFallBackService.class)
public interface PaymentService {

    @GetMapping("/payment/hystrix/ok/{id}")
    String paymentSuccess(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentTimeout(@PathVariable("id") Integer id);
}
