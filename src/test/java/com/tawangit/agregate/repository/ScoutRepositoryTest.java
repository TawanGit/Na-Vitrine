package com.tawangit.agregate.repository;

import com.tawangit.agregate.controller.scout.CreateScoutDto;
import com.tawangit.agregate.entity.Scout;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.UUID;

import static  org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
class ScoutRepositoryTest {
// h2 database é mt usado para testes

    @Autowired
    ScoutRepository scoutRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("should return scout by id")
    void findScoutByIdSuccess() {
        Scout data = this.createScout();
        Optional<Scout> result = this.scoutRepository.findById(data.getScoutId());

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not return scout by id")
    void findScoutByIdNotFound() {
        Optional<Scout> result = this.scoutRepository.findById(UUID.fromString("12345678-1234-1234-1234-123456789012"));

        assertThat(result.isEmpty()).isTrue();
    }
    private Scout createScout() {
        Scout newScout = new Scout();
        newScout.setScoutName("tawan");
        newScout.setEmail("231312@gmail.com");
        newScout.setClub("milan");
        entityManager.persist(newScout);
        entityManager.flush();
        return newScout;
    }


}