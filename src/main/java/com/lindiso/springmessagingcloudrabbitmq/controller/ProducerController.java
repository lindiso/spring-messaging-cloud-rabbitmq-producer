package com.lindiso.springmessagingcloudrabbitmq.controller;

import com.lindiso.springmessagingcloudrabbitmq.producer.MessageSender;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    private MessageChannel messageChannel;

    public ProducerController(MessageSender messageSender) {
        this.messageChannel = messageSender.sendMessage();
    }
    @GetMapping("/greet/{name}")
    public void publish(@PathVariable String name) {
        String greeting = "Hello, " + name + "!";
        Message<String> msg = MessageBuilder.withPayload(greeting)
                .build();
        this.messageChannel.send(msg);
    }
}
