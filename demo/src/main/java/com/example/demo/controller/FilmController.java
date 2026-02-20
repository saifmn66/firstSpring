package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Film;
import com.example.demo.service.IServiceCtaegorie;
import com.example.demo.service.IServiceFilm;

import org.springframework.ui.Model;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
@RequestMapping("/films")
@AllArgsConstructor
public class FilmController {
    IServiceFilm iServiceFilm;
    IServiceCtaegorie iServiceCategories;

    @GetMapping("/all")
    public String listFilm(Model model) {
        model.addAttribute("films", iServiceFilm.findAllFilms());
        return "affiche";
    }

    @GetMapping("/add")
    public String getMethodName(Model model) {
        model.addAttribute("categories", iServiceCategories.getAllCategories());
        return "ajout";
    }

    @PostMapping("/add")
    public String postMethodName(Film film) {
        iServiceFilm.createFilm(film);
        return "redirect:/films/all";
    }
    
}
