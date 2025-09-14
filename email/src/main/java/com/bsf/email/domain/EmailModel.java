package com.bsf.email.domain;

import com.bsf.email.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "tb_email")
public class EmailModel implements Serializable {

    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "email_id")
    private UUID emailId;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "email_from")
    private String emailFrom;

    @Column(name = "email_to")
    private String emailTo;

    @Column(name = "email_subject")
    private String subject;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @CreationTimestamp
    @Column(name = "send_date_email")
    private LocalDateTime sendDateEmail;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_email")
    private StatusEmail statusEmail;

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UUID getEmailId() {
        return emailId;
    }

    public void setEmailId(UUID emailId) {
        this.emailId = emailId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }

    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public StatusEmail getStatusEmail() {
        return statusEmail;
    }

    public void setStatusEmail(StatusEmail statusEmail) {
        this.statusEmail = statusEmail;
    }

    public EmailModel() {
    }

    public EmailModel(UUID emailId, UUID userId, String emailFrom, String emailTo, String subject, String body, LocalDateTime sendDateEmail, StatusEmail statusEmail) {
        this.emailId = emailId;
        this.userId = userId;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.body = body;
        this.sendDateEmail = sendDateEmail;
        this.statusEmail = statusEmail;
    }
}
