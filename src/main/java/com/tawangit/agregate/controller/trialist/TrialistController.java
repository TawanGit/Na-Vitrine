package com.tawangit.agregate.controller.trialist;

import com.tawangit.agregate.controller.dtos.InviteTrialistDto;
import com.tawangit.agregate.controller.dtos.TakeTrialistDto;
import com.tawangit.agregate.entity.Trialist;
import com.tawangit.agregate.service.TrialistService;
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

    @GetMapping("/{scoutId}")
    public ResponseEntity <List<Trialist>> getTrialistsByScoutId(@PathVariable UUID scoutId) {
        return trialistService.takeTrialists(scoutId);
    }
}
