package xyz.huanju.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import xyz.huanju.cloud.domain.CommonResult;

/**
 * @author HuanJu
 * @date 2020/8/2 0:12
 *
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException e){

        return new CommonResult(500,"自定义全局异常处理");

    }

    public static CommonResult handlerException2(BlockException e){

        return new CommonResult(500,"自定义全局异常处理2");

    }

}
