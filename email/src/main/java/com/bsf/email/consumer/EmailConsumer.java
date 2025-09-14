package com.bsf.email.consumer;

import com.bsf.email.domain.EmailModel;
import com.bsf.email.dto.EmailDTO;
import com.bsf.email.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    private final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "email-queue")
    public void listen(@Payload EmailDTO emailDTO) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        System.out.println("Received email DTO: " + emailDTO.emailTo());
        emailService.sendSimpleEmail(emailModel);
    }
}
