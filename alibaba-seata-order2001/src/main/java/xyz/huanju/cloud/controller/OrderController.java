package xyz.huanju.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.huanju.cloud.domain.CommonResult;
import xyz.huanju.cloud.entity.Order;
import xyz.huanju.cloud.service.OrderService;

import javax.annotation.Resource;

/**
 * @author HuanJu
 * @date 2020/8/3 20:01
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }


}
