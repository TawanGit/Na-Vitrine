package com.tawangit.agregate.service;

import com.tawangit.agregate.controller.scout.UpdateScoutDto;
import com.tawangit.agregate.entity.Scout;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
class ScoutServiceTest {


    @Autowired
    ScoutService scoutService;

    @Autowired
    EntityManager entityManager;


    private Scout createScoutForTest() {
        Scout scout = new Scout();
        scout.setScoutName("Test Scout");
        scout.setClub("Test Club");
        scout.setEmail("thiago_tawan@outlook.com");
        entityManager.persist(scout);
        entityManager.flush();

        return scout;
    }

    @Test
    void createScout() {
        var data = createScoutForTest();

        assertThat(data).isNotNull();
        assertThat(data.getScoutId()).isInstanceOf(UUID.class);
        assertThat(data.getScoutName()).isEqualTo("Test Scout");
        assertThat(data.getEmail()).isEqualTo("thiago_tawan@outlook.com");
    }

    @Test
    void getScoutById() {
    var scoutId = createScoutForTest().getScoutId();
    var scout = scoutService.getScoutById(scoutId.toString());

        assertThat(scout).isPresent();
        assertThat(scout.get().getScoutName()).isEqualTo("Test Scout");

    }

    @Test
    void getScoutsList() {
        var scout1 = createScoutForTest();
        var scout2 = createScoutForTest();

        var scoutsList = scoutService.getScoutsList();

        assertThat(scoutsList).isNotEmpty();
        assertThat(scoutsList.size()).isEqualTo(2);
        assertThat(scoutsList.get(0).getScoutName()).isEqualTo(scout1.getScoutName());
        assertThat(scoutsList.get(1).getScoutName()).isEqualTo(scout2.getScoutName());
    }

    @Test
    void deleteScoutById() {
        var scout = createScoutForTest();
        var scoutId = scout.getScoutId().toString();

        scoutService.deleteScoutById(scoutId);
    }

    @Test
    void updateScoutById() {
        var scout = createScoutForTest();
        var scoutId = scout.getScoutId().toString();

        UpdateScoutDto updateScout = new UpdateScoutDto("Updated Scout", "12", "flamengo");

        scoutService.updateScoutById(scoutId, updateScout);

        var updatedScout = scoutService.getScoutById(scoutId);

        var updatedScoutWithData = updatedScout.orElseThrow(() -> new RuntimeException("Scout not found after update"));

        assertThat(updatedScoutWithData.getScoutName()).isEqualTo("Updated Scout");
        assertThat(updatedScoutWithData.getClub()).isEqualTo("flamengo");
        assertThat(updatedScoutWithData.getPassword()).isEqualTo("12");


    }


}