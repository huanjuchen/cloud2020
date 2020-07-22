package xyz.huanju.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.huanju.cloud.feign.PaymentService;

import javax.annotation.Resource;

/**
 * @author HuanJu
 * @date 2020/7/21 2:33
 */
@RestController
@Slf4j
//全局降级配置
//@DefaultProperties(defaultFallback = "paymentGlobalFallback")
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentSuccess(@PathVariable("id") Integer id) {
        return paymentService.paymentSuccess(id);
    }

//    @HystrixCommand(fallbackMethod = "paymentFallback",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id) {
        return paymentService.paymentTimeout(id);
    }


    public String paymentFallback(Integer id){

        return "调用远程服务出现异常或自身出现异常";
    }


    /**
     * 全局降级FallBack
     */
    public String paymentGlobalFallback(){
        return "调用远程服务出现异常或自身出现异常";
    }

}
