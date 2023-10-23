package com.bosch.user.producers;

import com.bosch.user.dto.EmailDTO;
import com.bosch.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessage(UserModel userModel){
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setUserId(userModel.getUserId());
        emailDTO.setTo(userModel.getEmail());
        emailDTO.setSubject("Cadastro realizado com sucesso");
        emailDTO.setText(userModel.getName() + "Seja bem vindo");

        rabbitTemplate.convertAndSend("", routingKey, emailDTO) ;
    }
}
