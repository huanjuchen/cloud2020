package xyz.huanju.cloud.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.huanju.cloud.dao.OrderDao;
import xyz.huanju.cloud.entity.Order;
import xyz.huanju.cloud.service.AccountService;
import xyz.huanju.cloud.service.OrderService;
import xyz.huanju.cloud.service.StorageService;

import javax.annotation.Resource;

/**
 * @author HuanJu
 * @date 2020/8/3 18:39
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;


    @Override
    @GlobalTransactional(name = "ez_tx_group",rollbackFor = Exception.class)
    public void create(Order order) {
        /*
        创建订单->调用库存服务扣减库存->调用账户扣余额->修改订单状态
         */
        //创建订单
        log.info("开始新建订单 ...");
        orderDao.create(order);

        //调用库存服务扣减库存
        log.info("调用库存微服务，做扣减  开始");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("调用库存微服务，做扣减  结束");

        //调用账户扣余额
        log.info("调用账户微服务，做扣减  开始");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("调用账户微服务，做扣减  结束");

        //修改订单状态
        log.info("修改订单状态  开始");
        orderDao.update(order.getId(),0);
        log.info("修改订单状态  结束");

        log.info("下订单  结束");

    }
}
