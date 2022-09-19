package com.cicd.demo.controller;



import com.cicd.demo.config.MQConfig;
import com.cicd.demo.entity.CustomerMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@ComponentScan
public class MessagePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/publish")
    public String publish(@RequestBody CustomerMessage customerMessage){
        customerMessage.setMessageID(UUID.randomUUID().toString());
        customerMessage.setMessageDate(new Date());
        rabbitTemplate.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY,customerMessage);
        return "message published.";
    }
}
