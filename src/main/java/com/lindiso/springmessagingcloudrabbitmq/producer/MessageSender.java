package com.lindiso.springmessagingcloudrabbitmq.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface MessageSender {

    @Output("greetings")
    MessageChannel sendMessage();
}
