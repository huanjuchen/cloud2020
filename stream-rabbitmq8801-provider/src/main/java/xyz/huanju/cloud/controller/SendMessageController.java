package xyz.huanju.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.huanju.cloud.service.MessageProvider;

import javax.annotation.Resource;

/**
 * @author HuanJu
 * @date 2020/7/24 0:27
 */
@RestController
public class SendMessageController {

    @Resource
    private MessageProvider messageProvider;

    @GetMapping(value = "/send")
    public String sendMsg(){
        return messageProvider.send();
    }


}
