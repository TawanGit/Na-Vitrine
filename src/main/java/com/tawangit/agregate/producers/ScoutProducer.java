package com.tawangit.agregate.producers;

import com.tawangit.agregate.dtos.EmailDto;
import com.tawangit.agregate.entity.Scout;
import com.tawangit.agregate.repository.ScoutRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ScoutProducer {

    final RabbitTemplate rabbitTemplate;

    public ScoutProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @Value("${broker.queue.email.name}") // o mesmo nome no arquivo application.properties
    private String routingKey;

    public void publishMessageEmail(String email, String inviteLink) {
        EmailDto emailDto = new EmailDto();
        emailDto.setEmail(email);
        emailDto.setInviteLink(inviteLink);
        emailDto.setSubject("Convite para Trialist");
        emailDto.setText("Você foi convidado para ser um participante da peneira. Clique no link para aceitar o convite: " + inviteLink);

        rabbitTemplate.convertAndSend("", routingKey, emailDto);

    }
}
