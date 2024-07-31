package com.jm.anota_ai_desafio.services;

import com.jm.anota_ai_desafio.domain.category.Category;
import com.jm.anota_ai_desafio.domain.category.CategoryDTO;
import com.jm.anota_ai_desafio.exception.CategoryNotFoundException;
import com.jm.anota_ai_desafio.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category insert(CategoryDTO categoryData) {
        if (categoryData.title() == null || categoryData.title().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (categoryData.description() == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        if (categoryData.ownerId() == null || categoryData.ownerId().isEmpty()) {
            throw new IllegalArgumentException("OwnerId cannot be empty");
        }
        if (repository.existsByTitle(categoryData.title())) {
            throw new IllegalStateException("Category with title '" + categoryData.title() + "' already exists");
        }

        Category newCategory = new Category();
        newCategory.setTitle(categoryData.title());
        newCategory.setDescription(categoryData.description());
        newCategory.setOwnerId(categoryData.ownerId());
        return repository.save(newCategory);
    }

    public List<Category> findAll() {
        return repository.findAll();
    }


    public Category findById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }

        return repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }


    public Category update(String id, CategoryDTO categoryData) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }

        Category existingCategory = repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        if (categoryData.title() == null || categoryData.title().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (categoryData.description() == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        if (categoryData.ownerId() == null || categoryData.ownerId().isEmpty()) {
            throw new IllegalArgumentException("OwnerId cannot be empty");
        }

        existingCategory.setTitle(categoryData.title());
        existingCategory.setDescription(categoryData.description());
        existingCategory.setOwnerId(categoryData.ownerId());
        return repository.save(existingCategory);
    }

    public void delete(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be empty");
        }

        Category existingCategory = repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));

        repository.delete(existingCategory);
    }
}
