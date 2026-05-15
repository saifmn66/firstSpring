package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Categories;

public interface IServiceCtaegorie {

    Categories addCategory(Categories category);

    List<Categories> getAllCategories();

    Optional<Categories> getCategoryById(Long id);

    void deleteCategory(Long id);

    Categories updateCategory(Long id, Categories category);
}
