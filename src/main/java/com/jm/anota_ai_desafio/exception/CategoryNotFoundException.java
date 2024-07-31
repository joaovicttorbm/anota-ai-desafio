package com.jm.anota_ai_desafio.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String id) {
        super("Category with id " + id + " not found");
    }
}