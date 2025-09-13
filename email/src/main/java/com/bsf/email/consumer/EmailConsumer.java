package com.bsf.email.consumer;

import com.bsf.email.dto.EmailDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @RabbitListener(queues = "email-queue")
    public void listen(@Payload EmailDTO emailDTO) {
        System.out.println(emailDTO.emailTo());
    }
}
