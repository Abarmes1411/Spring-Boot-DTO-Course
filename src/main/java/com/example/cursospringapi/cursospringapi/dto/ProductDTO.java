package com.example.cursospringapi.cursospringapi.dto;

import com.example.cursospringapi.cursospringapi.model.Category;
import com.example.cursospringapi.cursospringapi.model.ProductState;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class ProductDTO {
    
    private Long idProduct;

    @NotBlank (message = "The name of the product cannot be empty")
    @Size (max = 100, message = "The name of the product cannot exceed 100 characters")
    private String nameProduct;

    @Size (max = 200, message = "The description of the product cannot exceed 200 characters")
    private String descriptionProduct;
    
    @NotNull (message = "The price of the product cannot be null")
    private Double priceProduct;
    
    @NotNull (message = "The quantity of the product cannot be null")
    @Min (value = 0, message = "The quantity of the product cannot be negative")
    private int quantityProduct;
    
    @NotNull (message = "The state of the product cannot be null")
    private ProductState stateProduct;
    

    private Category category;
}
