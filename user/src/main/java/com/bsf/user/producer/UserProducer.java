package com.bsf.user.producer;

import com.bsf.user.domain.UserModel;
import com.bsf.user.dto.EmailDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    private final String routingKey = "email-queue";

    public void sendUser(UserModel userModel) {
        EmailDTO emailDTO = new EmailDTO(
                userModel.getUserId(),
                userModel.getEmail(),
                "Welcome to our service",
                "Thank you "+ userModel.getName() +" for registering with us!"
        );
        rabbitTemplate.convertAndSend("",routingKey, emailDTO);
    }

}
