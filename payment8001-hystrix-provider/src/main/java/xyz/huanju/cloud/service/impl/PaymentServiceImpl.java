package xyz.huanju.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import xyz.huanju.cloud.service.PaymentService;

import java.util.concurrent.TimeUnit;

/**
 * @author HuanJu
 * @date 2020/7/21 1:44
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    //====================服务降级

    /**
     * 正常访问
     */
    @Override
    public String paymentInfoSuccess(Integer id) {
        return "线程：" + Thread.currentThread().getName() + "\tSUCCESS\tid: " + id;
    }

    //超时后调用timeoutHandler方法
    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public String paymentInfoTimeout(Integer id) {

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程：" + Thread.currentThread().getName() + "\tTIMEOUT\tid: " + id;
    }

    @Override
    public String timeoutHandler(Integer id) {
        return "线程：" + Thread.currentThread().getName() + "\t系统繁忙\tid: " + id;
    }


    //=======================服务熔断



    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack",commandProperties = {
            //开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            //请求次数阈值 10次
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            // 最大失败率，超过后跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")

            /*
            在时间窗口期之内（10000 ms），请求次数达到阈值（10），失败次数占比达到60% 跳闸
             */

    })
    @Override
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("**** id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t调用成功，流水号：" + serialNumber;
    }


    //熔断处理方法
    @Override
    public String paymentCircuitBreakerFallBack(Integer id) {
        return "id 不能为负数  id: " + id;
    }


}
