package com.bosch.email.service.classes;

import com.bosch.email.enums.StatusEmail;
import com.bosch.email.models.EmailModel;
import com.bosch.email.repository.EmailRepository;
import com.bosch.email.service.interfaces.EmailServiceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EmailServiceGmailImp implements EmailServiceUseCase {

    @Autowired
    private EmailRepository emailRepository;

    final JavaMailSender emailSender;

    public EmailServiceGmailImp(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public void sendEmail(EmailModel emailModel){
        try{
            emailModel.setSendDateEmail(LocalDateTime.now());
            emailModel.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailModel.getTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        } finally {
            emailRepository.save(emailModel);

        }
    }
}
