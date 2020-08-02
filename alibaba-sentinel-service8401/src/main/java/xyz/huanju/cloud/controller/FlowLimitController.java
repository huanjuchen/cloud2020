package xyz.huanju.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author HuanJu
 * @date 2020/7/30 17:41
 */
@RestController
@Slf4j
public class FlowLimitController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/testA")
    public String testA() {
        return "test A, port: " + port;
    }

    @GetMapping("/testB")
    public String testB() {
        return "test B, port: " + port;
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "test D, port: " + port;
    }


    /**
     * 用于测试熔断降级 异常比例
     */
    @GetMapping("/testE")
    public String testE() {

        log.info("testE 测试异常比例");

        int i = 10 / 0;

        return "test E, port: " + port;
    }

    /**
     * 用于测试熔断降级 异常数
     */
    @GetMapping("/testF")
    public String testF() {

        log.info("testF 测试异常数");

        int i = 10 / 0;

        return "test F, port: " + port;
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "handleTestHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                              @RequestParam(value = "p2", required = false) String p2) {
        return "<h1>Test HotKey</h1>";
    }


    public String handleTestHotKey(String p1, String p2, BlockException e){
        return "<h1>Handle Test Hot Key  handle handle Exception</h1>";
    }


}
