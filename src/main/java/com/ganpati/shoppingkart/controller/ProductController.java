package com.ganpati.shoppingkart.controller;

import com.ganpati.shoppingkart.dto.ProductDTO;
import com.ganpati.shoppingkart.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(
        name = "Product API CRUD Operation",
        description = "CREATE, READ, UPDATE and DELETE operations for Product API"
)
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
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getAllProductById(id), HttpStatus.FOUND);
    }

    // Update Products details:-
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.updateProduct(id, productDTO), HttpStatus.OK);
    }

    // Delete product by id:-
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }
}