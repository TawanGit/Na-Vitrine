package com.tawangit.agregate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendInviteEmail(String to, String inviteLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Você foi convidado para se cadastrar");
        message.setText("Olá! Você foi convidado para se cadastrar. Use o link abaixo:\n" + inviteLink);
        mailSender.send(message);
    }
    }
