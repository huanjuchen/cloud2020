package xyz.huanju.cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.huanju.cloud.domain.Payment;

/**
 * @author HuanJu
 * @date 2020/7/11 14:55
 */
@Mapper
public interface PaymentDAO {

    int save(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
