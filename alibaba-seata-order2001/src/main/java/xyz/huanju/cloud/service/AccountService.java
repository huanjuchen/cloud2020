package xyz.huanju.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.huanju.cloud.domain.CommonResult;

import java.math.BigDecimal;

/**
 * @author HuanJu
 * @date 2020/8/3 18:40
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {


    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long id,
                          @RequestParam("money") BigDecimal money);


}
