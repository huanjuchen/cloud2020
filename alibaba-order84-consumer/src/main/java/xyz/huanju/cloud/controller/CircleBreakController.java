package xyz.huanju.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import xyz.huanju.cloud.domain.CommonResult;
import xyz.huanju.cloud.domain.Payment;

import javax.annotation.Resource;

/**
 * @author HuanJu
 * @date 2020/8/2 1:47
 */
@RestController
@Slf4j
public class CircleBreakController {

    @Value("${server-url.payment-service}")
    public String serviceURL;

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("paymentSQL/{id}")
//    @SentinelResource(value = "fallbackDemo") //不配置
//    @SentinelResource(value = "fallbackDemo",fallback = "handleFallBack") //配置FallBack
//    @SentinelResource(value = "fallbackDemo",blockHandler = "handleBlock") //只配置block
//    @SentinelResource(value = "fallbackDemo",
//            blockHandler = "handleBlock",fallback = "handleFallBack") //同时配置block和FallBack  同时满足时，只进入blockHandler的方法
    @SentinelResource(value = "fallbackDemo",
            blockHandler = "handleBlock",fallback = "handleFallBack",
    //忽略
    exceptionsToIgnore = IllegalArgumentException.class) //配置忽略的异常
    public CommonResult paymentSQL(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(serviceURL + "/paymentSQL/" + id,
                CommonResult.class);

        if (id==4||id<=0){
            throw new IllegalArgumentException("IllegalArgumentException，非法参数异常");
        }else if (result==null||result.getData()==null){
            throw new NullPointerException("NullPointerException，该ID没有对应的值");
        }
        return result;
    }


    /**
     * FallBack 处理方法
     */
    public CommonResult handleFallBack(Long id,Throwable e){
        Payment payment=new Payment(id,"NULL");
        return new CommonResult(405,"Handler FallBack ,异常信息："+e.getMessage(),payment);

    }


    /**
     * 处理 Block
     */
    public CommonResult handleBlock(Long id, BlockException e){
        Payment payment=new Payment(id,"NULL");
        return new CommonResult(405,"Handler Block,异常信息："+e.getMessage(),payment);
    }





}
