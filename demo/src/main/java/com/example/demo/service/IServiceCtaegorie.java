package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Categories;

public interface IServiceCtaegorie {

    Categories addCategory(Categories category);

    List<Categories> getAllCategories();

    Categories getCategoryById(int id);

    void deleteCategory(int id);

    Categories updateCategory(int id, Categories category);
}
