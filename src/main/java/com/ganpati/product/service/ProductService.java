package com.ganpati.product.service;

import com.ganpati.product.dto.ProductDTO;
import com.ganpati.product.entity.Category;
import com.ganpati.product.entity.Product;
import com.ganpati.product.mapper.ProductMapper;
import com.ganpati.product.repository.CategoryRepository;
import com.ganpati.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO){
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category Not Found!"));
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    public ProductDTO getAllProductById(Long id){
        Product product =  productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));
        return ProductMapper.toProductDTO(product);
    }
}