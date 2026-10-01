package com.example.cursospringapi.cursospringapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.cursospringapi.cursospringapi.dto.CategoryDTO;
import com.example.cursospringapi.cursospringapi.exceptions.ResourceNotFoundException;
import com.example.cursospringapi.cursospringapi.mapper.CategoryMapper;
import com.example.cursospringapi.cursospringapi.model.Category;
import com.example.cursospringapi.cursospringapi.repository.RepositoryCategory;
import com.example.cursospringapi.cursospringapi.service.CategoryService;

@Service 
public class CategoryServiceImpl implements CategoryService {
    
    
    private final RepositoryCategory repositoryCategory;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(RepositoryCategory repositoryCategory, CategoryMapper categoryMapper) {
        this.repositoryCategory = repositoryCategory;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        Category savedCategory = repositoryCategory.save(category);
        return categoryMapper.toDTO(savedCategory);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = repositoryCategory.findAll();
        return categories.stream()
                .map(categoryMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<CategoryDTO> getCategoryById(Long idCategory) {
        return repositoryCategory.findById(idCategory).map(categoryMapper::toDTO);
    }

    @Override
    public CategoryDTO updateCategory(Long idCategory, CategoryDTO categoryDTO) {

        Category existingCategory = repositoryCategory.findById(idCategory)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Category not found with id: " + idCategory
                        )
                );

        existingCategory.setCategoryName(categoryDTO.getNameCategory());

        return categoryMapper.toDTO(
                repositoryCategory.save(existingCategory)
        );
    }
    

    @Override
    public void deleteCategory(Long idCategory) {
        repositoryCategory.deleteById(idCategory);
    }

    
}
