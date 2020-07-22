package xyz.huanju.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;


/**
 * @author HuanJu
 * @date 2020/7/20 0:22
 *
 * 自定义负载均衡
 *
 */


public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
