package com.tawangit.agregate.controller.trialist;

import com.tawangit.agregate.service.TrialistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/trialist")
public class TrialistController {

    private final TrialistService trialistService; // step 1

    public TrialistController(TrialistService trialistService) {
        this.trialistService = trialistService;
    }
    
    @PostMapping("/invite")
    public ResponseEntity <String> inviteTrialist(@RequestBody InviteTrialistDto inviteTrialistDto) {
    return trialistService.invite(inviteTrialistDto);
    }

    public enum TrialistPosition {
            GOALKEEPER,        // Goleiro
            RIGHT_BACK,        // Lateral Direito
            LEFT_BACK,         // Lateral Esquerdo
            CENTER_BACK,       // Zagueiro
            DEFENSIVE_MIDFIELDER, // Volante
            CENTRAL_MIDFIELDER,   // Meio-campista Central
            ATTACKING_MIDFIELDER, // Meia Ofensivo
            RIGHT_WINGER,      // Ponta Direita
            LEFT_WINGER,       // Ponta Esquerda
            STRIKER,           // Atacante / Centroavante
            SECOND_STRIKER     // Segundo Atacante

    }
}
