package xyz.huanju.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.huanju.cloud.domain.CommonResult;
import xyz.huanju.cloud.feign.fallback.PaymentFallBackService;

/**
 * @author HuanJu
 * @date 2020/8/2 16:28
 */
@FeignClient(value = "payment-provider-nacos",fallback = PaymentFallBackService.class)
public interface PaymentService {

    @GetMapping("/paymentSQL/{id}")
    public CommonResult paymentSQL(@PathVariable("id") Long id);

}
