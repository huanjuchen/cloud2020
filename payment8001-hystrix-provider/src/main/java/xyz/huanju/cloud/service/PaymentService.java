package xyz.huanju.cloud.service;

/**
 * @author HuanJu
 * @date 2020/7/21 1:43
 */
public interface PaymentService {

    String paymentInfoSuccess(Integer id);

    String paymentInfoTimeout(Integer id);

    String timeoutHandler(Integer id);

    String paymentCircuitBreakerFallBack(Integer id);

    String paymentCircuitBreaker(Integer id);


}
