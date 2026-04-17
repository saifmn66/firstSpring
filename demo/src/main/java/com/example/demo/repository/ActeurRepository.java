package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Acteur;


public interface ActeurRepository extends JpaRepository<Acteur, Integer> {
    List<Acteur> findByNom(String nom);
}
