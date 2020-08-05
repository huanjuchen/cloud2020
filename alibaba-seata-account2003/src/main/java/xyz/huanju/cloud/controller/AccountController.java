package xyz.huanju.cloud.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.huanju.cloud.domain.CommonResult;
import xyz.huanju.cloud.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author HuanJu
 * @date 2020/8/4 3:21
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减余额成功");

    }

}
