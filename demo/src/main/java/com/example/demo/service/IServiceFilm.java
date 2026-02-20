package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Film;

public interface IServiceFilm {
    public Film createFilm(Film film);
    public Optional<Film> findFilmById(int id);
    public List<Film> findAllFilms();
    public Film updateFilm(Film film);
    public Boolean deleteFilm(int id);
}
