package com.example.cursospringapi.cursospringapi.service;

import java.util.List;
import java.util.Optional;

import com.example.cursospringapi.cursospringapi.dto.CategoryDTO;

public interface CategoryService {
    
    CategoryDTO createCategory(CategoryDTO category);

    List<CategoryDTO> getAllCategories();

    Optional<CategoryDTO> getCategoryById(Long idCategory);

    CategoryDTO updateCategory(Long idCategory, CategoryDTO category);

    void deleteCategory(Long idCategory);

    
}
