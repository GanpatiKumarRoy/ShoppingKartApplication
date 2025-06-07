package com.ganpati.shoppingkart.service;

import com.ganpati.shoppingkart.dto.ProductDTO;
import com.ganpati.shoppingkart.entity.Category;
import com.ganpati.shoppingkart.entity.Product;
import com.ganpati.shoppingkart.exception.CategoryNotFoundException;
import com.ganpati.shoppingkart.mapper.ProductMapper;
import com.ganpati.shoppingkart.repository.CategoryRepository;
import com.ganpati.shoppingkart.repository.ProductRepository;
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
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new CategoryNotFoundException("Category id " + productDTO.getCategoryId() + " not exists!"));
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    public ProductDTO getAllProductById(Long id){
        Product product =  productRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Product id " + id + " not exists!"));
        return ProductMapper.toProductDTO(product);
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO){
        Product product =  productRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Product id " + id + " not exists!"));
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new CategoryNotFoundException("Category id " + productDTO.getCategoryId() + " not exists!"));

        product.setName(productDTO.getName());
        product.setCategory(category);
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    public String deleteProduct(Long id){
        productRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Product id " + id + " not exists!"));
        productRepository.deleteById(id);
        return "Product " + id + " has been deleted!";
    }
}