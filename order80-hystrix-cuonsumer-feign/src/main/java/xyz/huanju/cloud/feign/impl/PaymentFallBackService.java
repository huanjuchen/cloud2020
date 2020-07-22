package xyz.huanju.cloud.feign.impl;

import org.springframework.stereotype.Component;
import xyz.huanju.cloud.feign.PaymentService;

/**
 * @author HuanJu
 * @date 2020/7/21 16:55
 */
@Component
public class PaymentFallBackService implements PaymentService {
    @Override
    public String paymentSuccess(Integer id) {
        return "***paymentSuccess ERROR***";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "***paymentTimeout ERROR***";
    }
}
