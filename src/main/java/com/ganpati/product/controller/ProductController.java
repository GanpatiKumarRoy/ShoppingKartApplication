package com.ganpati.product.controller;

import com.ganpati.product.dto.ProductDTO;
import com.ganpati.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Add products with respective category:-
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }

    // Get all products:-
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.FOUND);
    }

    // Get product by ID:-
    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> getProductById(Long id){
        return new ResponseEntity<>(productService.getAllProductById(id), HttpStatus.FOUND);
    }
}