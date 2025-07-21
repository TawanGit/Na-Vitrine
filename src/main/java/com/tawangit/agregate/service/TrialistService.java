package com.tawangit.agregate.service;


import com.tawangit.agregate.controller.trialist.InviteTrialistDto;
import com.tawangit.agregate.entity.Trialist;
import com.tawangit.agregate.repository.TrialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TrialistService {

    @Autowired
    private TrialistRepository trialistRepository;

    @Autowired
    private EmailService emailService;

   public ResponseEntity<String> invite(InviteTrialistDto inviteTrialistDto) {
       String email = inviteTrialistDto.email();
       if(trialistRepository.existsByEmail(email)) {
           return ResponseEntity.badRequest().body("Este e-mail já foi convidado");
       }

       Trialist trialist = new Trialist();
       trialist.setEmail(email);
       trialist.setInviteToken(UUID.randomUUID().toString());
       trialistRepository.save(trialist);

       String inviteLink = trialist.getInviteToken();

       emailService.sendInviteEmail(email, inviteLink);

       return ResponseEntity.ok("Convite enviado por e-mail com sucesso.");
   }
}
