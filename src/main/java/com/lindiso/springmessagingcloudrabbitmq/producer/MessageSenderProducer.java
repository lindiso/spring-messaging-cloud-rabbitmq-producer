package com.lindiso.springmessagingcloudrabbitmq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MessageSenderProducer {
   static Logger logger = LoggerFactory.getLogger(MessageSenderProducer.class);

    @Qualifier(value = "greetings")
    private static MessageChannel messageChannel;

    @Autowired
    public MessageSenderProducer(@Qualifier("greetings") MessageChannel sendMessage) {
        this.messageChannel = sendMessage;
    }

    public static void sendMessage(){
        logger.info("About to send the message...........");
        Scanner input  = new Scanner(System.in);
        System.out.println("Please Enter your name.");
        String name = input.nextLine();
        String message = "Hello my name is," + name;
        Message<String> msg = MessageBuilder.withPayload(message)
                .build();
        messageChannel.send(msg);
        logger.info("Message sent..........."+ messageChannel);
    }
}
