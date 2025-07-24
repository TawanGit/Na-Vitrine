package com.tawangit.agregate.controller.trialist;

import com.tawangit.agregate.controller.dtos.InviteTrialistDto;
import com.tawangit.agregate.controller.dtos.TakeTrialistDto;
import com.tawangit.agregate.controller.dtos.TrialistUpdate;
import com.tawangit.agregate.entity.Trialist;
import com.tawangit.agregate.service.TrialistService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PutMapping("/{trialistId}")
    public ResponseEntity <String> updateTrialist(@PathVariable UUID trialistId, @Valid  @RequestBody TrialistUpdate trialistUpdate) {
        return trialistService.updateTrialist(trialistId, trialistUpdate);
    }

    @GetMapping("/{scoutId}")
    public ResponseEntity <List<Trialist>> getTrialistsByScoutId(@PathVariable UUID scoutId) {
        try {
            return trialistService.takeTrialists(scoutId);
        } catch (Exception e) {
            return ResponseEntity.status(200).body(List.of());
        }
    }
}
