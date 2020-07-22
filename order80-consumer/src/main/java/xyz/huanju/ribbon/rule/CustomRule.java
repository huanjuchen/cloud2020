package xyz.huanju.ribbon.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuanJu
 * @date 2020/7/19 16:32
 *
 * Ribbon自定义规则
 * 不能放在@ComponentScan扫描的当前包及其子包下
 *
 */
@Configuration
public class CustomRule {

    @Bean
    public IRule myRule(){
        //定义负载均衡规则为随机
        return new RandomRule();
    }

}
