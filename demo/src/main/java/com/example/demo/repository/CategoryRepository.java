package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Integer> {

    
} 
