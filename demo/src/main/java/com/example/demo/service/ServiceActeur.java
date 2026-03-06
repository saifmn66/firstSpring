package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Acteur;
import com.example.demo.repository.ActeurRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceActeur implements IServiceActeur {

    ActeurRepository acteurRepository;

    @Override
    public Acteur createActeur(Acteur acteur) {
        Optional<Acteur> existingActeur = acteurRepository.findByNom(acteur.getNom()).stream().findFirst();
        if(existingActeur.isEmpty()){
            return acteurRepository.save(acteur);
        } else {
            throw new RuntimeException("Acteur with name " + acteur.getNom() + " already exists.");
        }
    }

    @Override
    public Optional<Acteur> findActeurById(int id) {
        return acteurRepository.findById(id);
    }

    @Override
    public List<Acteur> findAllActeurs() {
        return acteurRepository.findAll();
    }
    

    @Override
    public Acteur updateActeur(Acteur acteur) {
        Optional<Acteur> existingActeur = acteurRepository.findById(acteur.getId());
        if(existingActeur.isPresent()){
            return acteurRepository.save(acteur);
        } else {
            throw new RuntimeException("Acteur with id " + acteur.getId() + " not found.");
        }
    }

    @Override
    public Boolean deleteActeur(int id) {
        Optional<Acteur> existingActeur = acteurRepository.findById(id);
        if(existingActeur.isPresent()){
            acteurRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Acteur with id " + id + " not found.");
        }
    }
    
}
