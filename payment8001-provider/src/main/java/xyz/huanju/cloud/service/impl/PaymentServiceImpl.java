package xyz.huanju.cloud.service.impl;

import org.springframework.stereotype.Service;
import xyz.huanju.cloud.dao.PaymentDAO;
import xyz.huanju.cloud.domain.Payment;
import xyz.huanju.cloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author HuanJu
 * @date 2020/7/11 15:10
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDAO paymentDAO;

    @Override
    public int save(Payment payment) {
        return paymentDAO.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDAO.getPaymentById(id);
    }
}
