package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Categories;
import com.example.demo.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService implements IServiceCtaegorie {

    
    private final CategoryRepository categoryRepository;

    @Override
    public Categories addCategory(Categories category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Categories> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Categories> getCategoryById(Long id) {
        return categoryRepository.findById(id.intValue());
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id.intValue());
    }

    @Override
    public Categories updateCategory(Long id, Categories category) {
        Categories c = categoryRepository.findById(id.intValue()).orElse(null);
        if (c != null) {
            c.setName(category.getName());
            return categoryRepository.save(c);
        }
        return null;
    }
}