package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Categories;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService implements IServiceCtaegorie {

    
    private CategoryRepository categoryRepository;

    @Override
    public Categories addCategory(Categories category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Categories> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Categories getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Categories updateCategory(int id, Categories category) {
        Categories c = categoryRepository.findById(id).orElse(null);
        if (c != null) {
            c.setName(category.getName());
            return categoryRepository.save(c);
        }
        return null;
    }
}