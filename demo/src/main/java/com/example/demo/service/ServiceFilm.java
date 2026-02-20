package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Film;
import com.example.demo.repository.FilmRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceFilm implements IServiceFilm {
    FilmRepository filmRepository;

    @Override
    public Film createFilm(Film film) {
       Optional<Film> nFilm = filmRepository.findByTitle(film.getTitle());
       if(nFilm.isEmpty()) {
        return filmRepository.save(film);
       }
       return null;
    }

    @Override
    public Optional<Film> findFilmById(int id) {
       return filmRepository.findById(id);
    }

    @Override
    public List<Film> findAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film updateFilm(Film film) {
        Optional<Film> nFilm = filmRepository.findById(film.getId());
        if(nFilm.isPresent()) {
            return filmRepository.save(film);
        }
        return null;
    }

    @Override
    public Boolean deleteFilm(int id) {
        Optional<Film> nFilm = filmRepository.findById(id);
        if(nFilm.isPresent()) {
            filmRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
