package xyz.huanju.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import xyz.huanju.cloud.domain.CommonResult;
import xyz.huanju.cloud.domain.Payment;
import xyz.huanju.cloud.lb.LoadBalancer;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author HuanJu
 * @date 2020/7/11 16:03
 */
@RestController
@Slf4j
public class OrderController {

    //    public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL="http://PAYMENT-PROVIDER";


//    @Resource
//    private LoadBalancer loadBalancer;
//
//    @Resource
//    private DiscoveryClient discoveryClient;


    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment")
    public CommonResult create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment", payment, CommonResult.class);
    }

//    public CommonResult


    @GetMapping("/consumer/payment/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/entity/{id}")
    public CommonResult getPayment2(@PathVariable Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            log.info("响应状态码: "+entity.getStatusCode());
            return entity.getBody();
        }else {
            return new CommonResult(444,"操作失败");
        }
    }

//    @GetMapping(value = "/consumer/payment/lb")
//    public String getPaymentLb(){
//        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT-PROVIDER");
//        if (instances==null||instances.size()<=0){
//            return null;
//        }
//
//        ServiceInstance serviceInstance=loadBalancer.instances(instances);
//        URI uri = serviceInstance.getUri();
//
//        return restTemplate.getForObject(uri+"/payment/lb",String.class);
//
//
//    }


}
