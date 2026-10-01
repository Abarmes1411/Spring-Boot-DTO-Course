package com.example.cursospringapi.cursospringapi.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.cursospringapi.cursospringapi.dto.ProductDTO;
import com.example.cursospringapi.cursospringapi.model.Product;

@Component 
public class ProductMapper {
    
    private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Product toEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

    public Product toEntity(ProductDTO productDTO, Product product) {
        modelMapper.map(productDTO, product);
        return product;
    }


    public ProductDTO toDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }


}