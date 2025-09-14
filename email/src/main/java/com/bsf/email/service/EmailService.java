package com.bsf.email.service;

import com.bsf.email.domain.EmailModel;
import com.bsf.email.dto.EmailDTO;
import com.bsf.email.enums.StatusEmail;
import com.bsf.email.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private final EmailRepository emailRepository;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public EmailService(JavaMailSender mailSender, EmailRepository emailRepository) {
        this.mailSender = mailSender;
        this.emailRepository = emailRepository;
    }

    @Transactional
    public void sendSimpleEmail(EmailModel emailModel) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getBody());

            mailSender.send(message);
            emailModel.setStatusEmail(StatusEmail.sent);
        } catch (Exception e) {
            System.out.println("Error sending email: " + e.getMessage());
            emailModel.setStatusEmail(StatusEmail.failed);
        }
        emailRepository.save(emailModel);

    }
}
