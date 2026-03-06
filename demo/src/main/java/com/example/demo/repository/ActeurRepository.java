package com.example.demo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Acteur;


public interface ActeurRepository extends JpaRepository<Acteur, Integer> {
    Optional<Acteur> findByName(String name);
}
