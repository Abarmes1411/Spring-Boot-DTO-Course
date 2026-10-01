package com.example.cursospringapi.cursospringapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class Product {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_product", nullable = false)
    private Long idProduct;

    @Column(name="name_product", nullable = false, length = 100)
    private String nameProduct;
    @Column(name="description_product", length = 255)
    private String descriptionProduct;
    @Column(name="price_product", nullable = false)
    private Double priceProduct;
    @Column(name="quantity_product", nullable = false)
    private int quantityProduct;
    @Enumerated (EnumType.STRING)
    @Column (name="state_product", nullable = false)
    private ProductState stateProduct;

    @ManyToOne 
    @JoinColumn (name="id_category", referencedColumnName = "id_category", nullable = false)
    private Category category;

}
