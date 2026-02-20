package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Film;

public interface FilmRepository extends JpaRepository<Film , Integer> {
    Optional<Film> findByTitle(String title);
}
