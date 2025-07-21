package com.tawangit.agregate.service;


import com.tawangit.agregate.controller.trialist.InviteTrialistDto;
import com.tawangit.agregate.entity.Scout;
import com.tawangit.agregate.entity.Trialist;
import com.tawangit.agregate.repository.ScoutRepository;
import com.tawangit.agregate.repository.TrialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
public class TrialistService {

    @Autowired
    private TrialistRepository trialistRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ScoutRepository scoutRepository;

   public ResponseEntity<String> invite(InviteTrialistDto inviteTrialistDto) {
       String email = inviteTrialistDto.email();
       if(trialistRepository.existsByEmail(email) ) {
           return ResponseEntity.badRequest().body("Este e-mail já foi convidado");
       }

       Optional<Scout> optionalScout = scoutRepository.findById(inviteTrialistDto.scoutId());

       if (optionalScout.isEmpty()) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Scout não encontrado");
       }

       Scout scout = optionalScout.get();


       Trialist trialist = new Trialist();
       trialist.setEmail(email);
       trialist.setScout(scout);
       trialist.setInviteToken(UUID.randomUUID().toString());
       trialistRepository.save(trialist);

       String inviteLink = trialist.getInviteToken();

       emailService.sendInviteEmail(email, inviteLink);

       return ResponseEntity.ok("Convite enviado por e-mail com sucesso.");
   }
}
