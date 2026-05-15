package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Film;

public interface FilmRepository extends JpaRepository<Film , Integer> {
    Optional<Film> findByTitle(String title);
    
    List<Film> findByTitleContainingIgnoreCase(String title);

    // Tri décroissant par année
    List<Film> findByOrderByReleaseYearDesc();

    // Filtrage par catégorie
    List<Film> findByCategoriesId(Long idcat);

    // Films par acteur
    List<Film> findByActeursId(int acteurId);
}
