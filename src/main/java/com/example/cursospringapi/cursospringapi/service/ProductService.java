package com.example.cursospringapi.cursospringapi.service;

import java.util.List;
import java.util.Optional;

import com.example.cursospringapi.cursospringapi.dto.ProductDTO;
import com.example.cursospringapi.cursospringapi.model.ProductState;

public interface ProductService {
    
    ProductDTO createProduct(Long categoryId, ProductDTO productDTO);

    List<ProductDTO> getAllProducts();

    Optional<ProductDTO> getProductById(Long idProduct);

    Optional<ProductDTO> getProductByName(String nameProduct);

    ProductDTO updateProduct(Long idProduct, ProductDTO productDTO);
    
    void deleteProduct(Long idProduct);

    ProductDTO updateProductState(Long idProduct, ProductState stateProduct);

    List<ProductDTO> getProductsByState(ProductState stateProduct);

}
