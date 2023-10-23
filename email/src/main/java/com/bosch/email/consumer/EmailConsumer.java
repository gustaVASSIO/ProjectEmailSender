package com.bosch.email.consumer;

import com.bosch.email.dto.EmailDTO;
import com.bosch.email.models.EmailModel;
import com.bosch.email.service.classes.EmailServiceGmailImp;
import com.bosch.email.service.interfaces.EmailServiceUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @Autowired
    private EmailServiceUseCase emailService;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenerQueue(@Payload EmailDTO dto){
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(dto, emailModel);
        emailService.sendEmail(emailModel);
//      System.out.println(dto.to());

    }
}
