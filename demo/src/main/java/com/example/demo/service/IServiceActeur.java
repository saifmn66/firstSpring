package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Acteur;

public interface IServiceActeur {
    public Acteur createActeur(Acteur acteur);
    public Optional<Acteur> findActeurById(int id);
    public List<Acteur> findAllActeurs();
    public Acteur updateActeur(Acteur acteur);
    public Boolean deleteActeur(int id);
    
} 