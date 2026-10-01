package com.example.cursospringapi.cursospringapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity 
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class Category {


    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="id_category", nullable = false)
    private Long idCategory;

    @Column (name="category_name", nullable = false, length = 100)
    private String categoryName;
    
}
