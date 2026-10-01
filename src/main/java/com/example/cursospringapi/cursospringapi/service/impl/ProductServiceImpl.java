package com.example.cursospringapi.cursospringapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.cursospringapi.cursospringapi.dto.ProductDTO;
import com.example.cursospringapi.cursospringapi.exceptions.ResourceNotFoundException;
import com.example.cursospringapi.cursospringapi.mapper.ProductMapper;
import com.example.cursospringapi.cursospringapi.model.Category;
import com.example.cursospringapi.cursospringapi.model.Product;
import com.example.cursospringapi.cursospringapi.model.ProductState;
import com.example.cursospringapi.cursospringapi.repository.RepositoryCategory;
import com.example.cursospringapi.cursospringapi.repository.RepositoryProduct;
import com.example.cursospringapi.cursospringapi.service.ProductService;

@Service 
public class ProductServiceImpl implements ProductService {

     
    private final RepositoryProduct repositoryProduct;
    private final RepositoryCategory repositoryCategory;
    private final ProductMapper productMapper;

      public ProductServiceImpl(RepositoryProduct repositoryProduct, RepositoryCategory repositoryCategory, ProductMapper productMapper) {
        this.repositoryProduct = repositoryProduct;
        this.repositoryCategory = repositoryCategory;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO createProduct(Long categoryId, ProductDTO productDTO) {

        Category category = repositoryCategory.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Category not found with id: " + categoryId
                        )
                );
        if (productDTO.getPriceProduct() == null ||
            productDTO.getPriceProduct() <= 0) {

            throw new IllegalArgumentException(
                    "Price must be greater than zero"
            );
        }
        Product product = productMapper.toEntity(productDTO);

        product.setCategory(category);

        Product savedProduct = repositoryProduct.save(product);

        return productMapper.toDTO(savedProduct);
}

    @Override
    public List<ProductDTO> getAllProducts() {
       List<Product> products = repositoryProduct.findAll();
       return products.stream()
               .map(productMapper::toDTO)
               .toList();
    }

    @Override
    public Optional<ProductDTO> getProductById(Long idProduct) {
        Optional<Product> productOptionalId = repositoryProduct.findById(idProduct);
        return productOptionalId.map(productMapper::toDTO);
    }

    @Override
    public Optional<ProductDTO> getProductByName(String nameProduct) {
        Optional<Product> productOptional = repositoryProduct.findByNameProduct(nameProduct);
        return productOptional.map(productMapper::toDTO);
    }

    @Override
    public ProductDTO updateProduct(Long idProduct, ProductDTO productDTO) {

        Product existingProduct = repositoryProduct.findById(idProduct)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found with id: " + idProduct
                        )
                );

        existingProduct.setNameProduct(productDTO.getNameProduct());
        existingProduct.setDescriptionProduct(productDTO.getDescriptionProduct());
        existingProduct.setPriceProduct(productDTO.getPriceProduct());
        existingProduct.setQuantityProduct(productDTO.getQuantityProduct());
        existingProduct.setStateProduct(productDTO.getStateProduct());

        return productMapper.toDTO(repositoryProduct.save(existingProduct));
    }

    @Override
    public void deleteProduct(Long idProduct) {
                Product productOptional = repositoryProduct.findById(idProduct).orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Product not found with id: " + idProduct
                        )
                );
        if (productOptional != null) {
            repositoryProduct.delete(productOptional);
        } else {
            // Handle the case when the product is not found
            // For example, you can throw an exception or log a message
        }

    }

    @Override
    public ProductDTO updateProductState(Long idProduct, ProductState stateProduct) {
        Optional<Product> productOptional = repositoryProduct.findById(idProduct);
        if (productOptional.isPresent()) {
            Product existingProduct = productOptional.get();
            existingProduct.setStateProduct(stateProduct);
            return productMapper.toDTO(repositoryProduct.save(existingProduct));
        } else {
            return null; // or throw an exception
        }
    }

    @Override
    public List<ProductDTO> getProductsByState(ProductState stateProduct) {
        List<Product> products = repositoryProduct.findByStateProduct(stateProduct);
        return products.stream()
                .map(productMapper::toDTO)
                    .toList();
    }
    
}
