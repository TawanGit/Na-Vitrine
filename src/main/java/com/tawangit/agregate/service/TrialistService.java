package com.tawangit.agregate.service;


import com.tawangit.agregate.controller.dtos.InviteTrialistDto;
import com.tawangit.agregate.controller.dtos.TakeTrialistDto;
import com.tawangit.agregate.controller.dtos.TrialistUpdate;
import com.tawangit.agregate.entity.Scout;
import com.tawangit.agregate.entity.Trialist;
import com.tawangit.agregate.producers.ScoutProducer;
import com.tawangit.agregate.repository.ScoutRepository;
import com.tawangit.agregate.repository.TrialistRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrialistService {

    @Autowired
    private TrialistRepository trialistRepository;



    @Autowired
    private ScoutRepository scoutRepository;

    @Autowired
    private ScoutProducer scoutProducer;

   public ResponseEntity<String> invite(InviteTrialistDto inviteTrialistDto) {
       String email = inviteTrialistDto.email();
       if(trialistRepository.existsByEmail(email) ) {
           return ResponseEntity.badRequest().body("Este e-mail já foi convidado");
       }

       Optional<Scout> optionalScout = scoutRepository.findById(inviteTrialistDto.scoutId());

       if (optionalScout.isEmpty()) {
           return ResponseEntity.badRequest().body("Scout não encontrado");
       }

       Scout scout = optionalScout.get();

       Trialist trialist = new Trialist();
       trialist.setEmail(email);
       trialist.setScout(scout);
       trialist.setInviteToken(UUID.randomUUID().toString());
       scout.getTrialists().add(trialist);

//       trialistRepository.save(trialist);
       scoutRepository.save(scout);
       String inviteLink = trialist.getInviteToken();

       scoutProducer.publishMessageEmail(email, inviteLink);

       return ResponseEntity.ok("Convite enviado por e-mail com sucesso.");
   }
   public ResponseEntity<String> updateTrialist(UUID trialistId, TrialistUpdate trialistUpdate) {
       Optional<Trialist> optionalTrialist = trialistRepository.findById(trialistId);

       if (optionalTrialist.isEmpty()) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trialist not found");
       }

       Trialist trialist = optionalTrialist.get();
       trialist.setName(trialistUpdate.name());
       trialist.setDocument(trialistUpdate.document());
       trialist.setCellphone(trialistUpdate.cellphone());
       trialist.setPositions(trialistUpdate.position());

       trialistRepository.save(trialist);

       return ResponseEntity.status(HttpStatus.OK)
               .body("Trialist updated with success.");
   }
   public ResponseEntity<List<Trialist>> takeTrialists(UUID scoutId) {
       Optional<Scout> scout = scoutRepository.findById(scoutId);

       if(scout.isEmpty()) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Scout não encontrado");
       }

       List<Trialist> trialists = scout.get().getTrialists();

       return ResponseEntity.ok(trialists);

   }
}
