package com.lindiso.springmessagingcloudrabbitmq;

import com.lindiso.springmessagingcloudrabbitmq.producer.MessageSender;
import com.lindiso.springmessagingcloudrabbitmq.producer.MessageSenderProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(MessageSender.class)
@SpringBootApplication
public class SpringMessagingProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMessagingProducerApplication.class, args);
		MessageSenderProducer.sendMessage();

	}


}
