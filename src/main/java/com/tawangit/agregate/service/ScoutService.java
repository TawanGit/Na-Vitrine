package com.tawangit.agregate.service;

import com.tawangit.agregate.controller.scout.CreateScoutDto;
import com.tawangit.agregate.controller.scout.UpdateScoutDto;
import com.tawangit.agregate.entity.Scout;
import com.tawangit.agregate.repository.ScoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScoutService {

    private ScoutRepository scoutRepository;

    public ScoutService(ScoutRepository scoutRepository) {
        this.scoutRepository = scoutRepository;
    }

    public UUID createScout(CreateScoutDto createScoutDto) {
        // DTO -> ENTITY
        var entity = new Scout();
        entity.setScoutName(createScoutDto.scoutName());
        entity.setClub(createScoutDto.club());
        entity.setDateOfBirth(createScoutDto.dateOfBirth());
        entity.setEmail(createScoutDto.email());
        entity.setPassword(createScoutDto.password());
        var scoutSaved = scoutRepository.save(entity);

        return scoutSaved.getScoutId();
    }

    public Optional<Scout> getScoutById(String scoutId) {
        return scoutRepository.findById(UUID.fromString(scoutId));
    }

    public List<Scout> getScoutsList() {
        return scoutRepository.findAll();
    }

    public void deleteScoutById(String scoutId) {
        var scoutExists = scoutRepository.existsById(UUID.fromString(scoutId));

        if(scoutExists) {
            scoutRepository.deleteById(UUID.fromString(scoutId));
        }
    }

    public void updateScoutById(String scoutId, UpdateScoutDto updateScoutDto) {
        var scoutEntity = scoutRepository.findById(UUID.fromString(scoutId));

        if(scoutEntity.isPresent()) {
         var scout = scoutEntity.get();

         if(updateScoutDto.scoutName() != null) {
             scout.setScoutName(updateScoutDto.scoutName());
         }

         if(updateScoutDto.password() != null) {
             scout.setPassword(updateScoutDto.password());
         }

         if(updateScoutDto.club() != null) {
             scout.setClub(updateScoutDto.club());
         }
            scoutRepository.save(scout);
        }


    }

}
