package com.example.cursospringapi.cursospringapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursospringapi.cursospringapi.model.Category;

 
public interface RepositoryCategory extends JpaRepository<Category, Long> {
    
Optional<Category> findByCategoryName(String categoryName);

boolean existsByCategoryName(String categoryName);



}
