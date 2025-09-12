package com.bsf.user.producer;

import com.bsf.user.domain.UserModel;
import com.bsf.user.dto.EmailDTO;
import com.bsf.user.mapper.UserMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class UserProducer {
    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    private final String routingKey = "email_queue";

    public void sendUserCreatedEvent(UserModel userModel) {
        EmailDTO emailDTO = new EmailDTO(
                userModel.getUserId(),
                userModel.getEmail(),
                "Welcome to our service",
                "Thank you for registering with us!"
        );
        rabbitTemplate.convertAndSend("","routingKey", userModel);
    }

}
