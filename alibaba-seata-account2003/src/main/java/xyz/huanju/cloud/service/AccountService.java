package xyz.huanju.cloud.service;

import java.math.BigDecimal;

/**
 * @author HuanJu
 * @date 2020/8/4 3:18
 */
public interface AccountService {

    void decrease(Long userId, BigDecimal money);

}
