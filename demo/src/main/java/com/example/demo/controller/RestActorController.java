package com.example.demo.controller;

import com.example.demo.entities.Acteur;
import com.example.demo.service.IServiceActeur;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actors")
@AllArgsConstructor
public class RestActorController {

    private IServiceActeur iServiceActor;

    @GetMapping("")
    public ResponseEntity<List<Acteur>> getAll() {
        return ResponseEntity.ok(iServiceActor.findAllActeurs());
    }

    @PostMapping("")
    public ResponseEntity<Acteur> create(@RequestBody Acteur actor) {
        Acteur created = iServiceActor.createActeur(actor);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("{id}")
    public ResponseEntity<Acteur> getById(@PathVariable Integer id) {
        Optional<Acteur> actor = iServiceActor.findActeurById(id);

        return actor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        iServiceActor.deleteActeur(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Acteur> update(
            @PathVariable Integer id,
            @RequestBody Acteur actor) {

        Optional<Acteur> existing = iServiceActor.findActeurById(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        actor.setId(id);
        Acteur updated = iServiceActor.updateActeur(actor);

        return ResponseEntity.ok(updated);
    }
}