package xyz.huanju.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.huanju.cloud.domain.CommonResult;
import xyz.huanju.cloud.domain.Payment;
import xyz.huanju.cloud.handler.CustomerBlockHandler;

/**
 * @author HuanJu
 * @date 2020/8/1 23:25
 * <p>
 * SentinelResource注解DEMO
 */
@RestController
public class RateLimitController {

    @GetMapping("/testResource")
    //value 资源名
    @SentinelResource(value = "testResource",blockHandler = "handleException")
    public CommonResult testResource() {
        return new CommonResult(200, "按资源名限流测试",
                new Payment(2020L, "Serial01"));
    }

    /**
     * 出现异常后处理的方法
     */
    public CommonResult handleException(BlockException e){
        return new CommonResult(500,e.getClass().getCanonicalName()+"\t服务不可用");
    }


    /**
     * 自定义异常处理类 处理方法
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            //自定义处理类
            blockHandlerClass = CustomerBlockHandler.class,
        //处理类中的方法
    blockHandler = "handlerException2")
    public CommonResult testCustomerBlockHandler(){
        return new CommonResult(200,"按用户自定义",new Payment(2020L,"Serial01"));
    }


}
