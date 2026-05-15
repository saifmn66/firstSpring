package com.example.demo.controller;

import com.example.demo.entities.Categories;
import com.example.demo.service.IServiceCtaegorie;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class RestCategoryController {

    private IServiceCtaegorie iServiceCategory;

    @GetMapping("")
    public ResponseEntity<List<Categories>> getAll() {
        return ResponseEntity.ok(iServiceCategory.getAllCategories());
    }

    @PostMapping("")
    public ResponseEntity<Categories> create(@RequestBody Categories category) {
        Categories created = iServiceCategory.addCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categories> getById(@PathVariable Long id) {
        Optional<Categories> category = iServiceCategory.getCategoryById(id);

        return category.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        iServiceCategory.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Categories> update(
            @PathVariable Long id,
            @RequestBody Categories category) {

        Optional<Categories> existing = iServiceCategory.getCategoryById(id);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        category.setId(id);
        Categories updated = iServiceCategory.updateCategory(id , category);

        return ResponseEntity.ok(updated);
    }
}