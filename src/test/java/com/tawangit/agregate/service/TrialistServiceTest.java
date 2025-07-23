package com.tawangit.agregate.service;

import com.tawangit.agregate.controller.dtos.TrialistUpdate;
import com.tawangit.agregate.controller.trialist.TrialistPosition;
import com.tawangit.agregate.entity.Trialist;
import com.tawangit.agregate.repository.TrialistRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
class TrialistServiceTest {

    @Autowired
    TrialistRepository trialistRepository;

    @Autowired
    TrialistService trialistService;

    @Autowired
    EntityManager entityManager;

    private Trialist createTrialistForTest() {
        Trialist trialist = new Trialist();
        entityManager.persist(trialist);
        entityManager.flush();
        return trialist;
    }
    @Test
    void invite() {
    }

    @Test
    void shouldUpdateTrialist() {
        var trialist = createTrialistForTest();
        var trialistId = trialist.getTrialistId();
        var updateDto = new TrialistUpdate(
                LocalDate.parse("2020-01-01"),
                 "12345678901",
                 "11987654321",
                "Test Trialist",
                TrialistPosition.valueOf("STRIKER")
        );

        var updatedTrialist = trialistService.updateTrialist(trialistId, updateDto);
        Trialist foundTrialist = trialistRepository.findById(trialistId).orElseThrow(() -> new RuntimeException("Trialist not found"));

        assertEquals("Test Trialist", foundTrialist.getName());
        assertEquals("12345678901", foundTrialist.getDocument());


    }


    @Test
    void takeTrialists() {
    }
}