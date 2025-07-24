package com.tawangit.agregate.controller.scout;


import com.tawangit.agregate.entity.Scout;
import com.tawangit.agregate.service.ScoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/scout")
public class ScoutController {
    private ScoutService scoutService;

    public ScoutController(ScoutService scoutService) {
        this.scoutService = scoutService;
    }

    // porta de entrada que chama a service
    // e a service chama o banco de dados.
    @PostMapping
    public ResponseEntity<Scout> createScout(@RequestBody CreateScoutDto createScoutDto){
      var scoutId =  scoutService.createScout(createScoutDto);
    return ResponseEntity.created(URI.create("/v1/scout/" + scoutId.toString())).build();
    }

    @GetMapping("/{scoutId}")
    public ResponseEntity<?> getScout(@PathVariable("scoutId") String scoutId) {
     try {
         var scout = scoutService.getScoutById(scoutId);
         return scout.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
     } catch (Exception e) {
         return ResponseEntity.status(500).body("erro // verificar se deu erro no banco de dados");
    }
    }
    @GetMapping
    public ResponseEntity<List<Scout>> listScouts() {
        var scouts = scoutService.getScoutsList();
        return  ResponseEntity.ok(scouts);
    }

    @PutMapping("/{scoutId}")
    public ResponseEntity<Map<String, String>> updateScout(@PathVariable("scoutId") String scoutId, @RequestBody UpdateScoutDto updateScoutDto) {
        scoutService.updateScoutById(scoutId, updateScoutDto);
        return ResponseEntity.ok(Map.of("Message", "Scout Updated"));
    }

    @DeleteMapping("/{scoutId}")
    public ResponseEntity<Map<String, String>> deleteScout(@PathVariable("scoutId") String scoutId) {
         scoutService.deleteScoutById(scoutId);
         return ResponseEntity.ok(Map.of("message", "Deleted"));

    }
}
