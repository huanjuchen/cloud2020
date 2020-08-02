package xyz.huanju.cloud.feign.fallback;

import org.springframework.stereotype.Component;
import xyz.huanju.cloud.domain.CommonResult;
import xyz.huanju.cloud.domain.Payment;
import xyz.huanju.cloud.feign.PaymentService;

/**
 * @author HuanJu
 * @date 2020/8/2 16:33
 */

@Component
public class PaymentFallBackService implements PaymentService {
    @Override
    public CommonResult paymentSQL(Long id) {
        return new CommonResult(500,"服务降级",new Payment(id,"Error Serial"));
    }
}
