package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IServiceFilm;
import com.example.demo.entities.Film;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/api/films")
@AllArgsConstructor
public class RestFilmController {

    IServiceFilm iServiceFilm;

    @GetMapping("")
    public ResponseEntity<List<Film>> getAll() {
        List<Film> films = iServiceFilm.findAllFilms();
        return ResponseEntity.ok(films);
    }

    @PostMapping("")
    public ResponseEntity<Film> createFilm(@RequestBody Film film) {
        Film createdFilm = iServiceFilm.createFilm(film);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFilm);
    }

    @GetMapping("{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Integer id) {
        Optional<Film> film = iServiceFilm.findFilmById(id);

        if (film.isPresent()) {
            return ResponseEntity.ok(film.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Integer id) {
        iServiceFilm.deleteFilm(id);
        return ResponseEntity.noContent().build(); // 204
    }

    @PutMapping("{id}")
    public ResponseEntity<Film> updateFilm(
            @PathVariable Integer id,
            @RequestBody Film film) {

        Optional<Film> existing = iServiceFilm.findFilmById(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        film.setId(id); 
        Film updated = iServiceFilm.updateFilm(film);

        return ResponseEntity.ok(updated);
    }
}