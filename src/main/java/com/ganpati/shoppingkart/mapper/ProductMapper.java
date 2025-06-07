package com.ganpati.shoppingkart.mapper;

import com.ganpati.shoppingkart.dto.ProductDTO;
import com.ganpati.shoppingkart.entity.Category;
import com.ganpati.shoppingkart.entity.Product;

public class ProductMapper {

    // Convert Entity to DTO:-
    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }

    // Convert DTO to Entity:-
    public static Product toProductEntity(ProductDTO productDTO, Category category){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return product;
    }
}