package com.example.cursospringapi.cursospringapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursospringapi.cursospringapi.dto.ProductDTO;
import com.example.cursospringapi.cursospringapi.model.ProductState;
import com.example.cursospringapi.cursospringapi.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/register/{categoryId}")
    public ResponseEntity<ProductDTO> registerProduct(
            @PathVariable Long categoryId,
            @RequestBody ProductDTO productDTO) {

        ProductDTO newProduct =
                productService.createProduct(categoryId, productDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newProduct);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> listProducts() {
        return ResponseEntity.ok(
                productService.getAllProducts()
        );
    }

    @PutMapping("/list/{id}")
    public ResponseEntity<ProductDTO> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDTO productDTO) {

        ProductDTO updatedProduct =
                productService.updateProduct(id, productDTO);

        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long id) {

        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity<Optional<ProductDTO>> searchByName(
            @PathVariable String name) {

        return ResponseEntity.ok(
                productService.getProductByName(name)
        );
    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity<Optional<ProductDTO>> searchById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                productService.getProductById(id)
        );
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<ProductDTO> updateProductState(
            @PathVariable Long id,
            @RequestBody ProductState stateProduct) {

        return ResponseEntity.ok(
                productService.updateProductState(id, stateProduct)
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ProductDTO>> getProductByState(
            @PathVariable ProductState status) {

        return ResponseEntity.ok(
                productService.getProductsByState(status)
        );
    }
}