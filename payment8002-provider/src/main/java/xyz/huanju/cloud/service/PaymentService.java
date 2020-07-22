package xyz.huanju.cloud.service;

import xyz.huanju.cloud.domain.Payment;

/**
 * @author HuanJu
 * @date 2020/7/11 15:09
 */
public interface PaymentService {

    int save(Payment payment);

    Payment getPaymentById(Long id);
}
