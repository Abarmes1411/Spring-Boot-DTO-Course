package com.example.cursospringapi.cursospringapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class CategoryDTO {
    

    private Long idCategory;

    @NotBlank (message = "The name of the category cannot be empty")
    @Size  (max = 100, message = "The name of the category cannot exceed 100 characters")
    private String nameCategory;
    
}
