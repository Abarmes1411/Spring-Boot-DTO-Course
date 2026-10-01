package com.example.cursospringapi.cursospringapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cursospringapi.cursospringapi.model.Product;
import com.example.cursospringapi.cursospringapi.model.ProductState;

public interface RepositoryProduct extends JpaRepository<Product, Long> {

    Optional<Product> findByIdProduct(Long idProduct);

    Optional<Product> findByNameProduct(String nameProduct);

    List<Product> findByStateProduct(ProductState stateProduct);
    
}
