package xyz.huanju.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import xyz.huanju.cloud.service.MessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author HuanJu
 * @date 2020/7/24 0:17
 */
//定义消息推送管道
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements MessageProvider {

    //消息发送管道
    @Resource
    private MessageChannel output;

    @Override
    public String send() {

        String serial= IdUtil.simpleUUID();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("***serial: "+serial);
        return "OK";
    }
}
