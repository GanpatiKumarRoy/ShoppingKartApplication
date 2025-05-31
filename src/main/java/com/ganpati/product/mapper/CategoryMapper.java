package com.ganpati.product.mapper;

import com.ganpati.product.dto.CategoryDTO;
import com.ganpati.product.entity.Category;

public class CategoryMapper {

    // Convert DTO to Entity:-
    public static Category toCategoryEntity(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return category;
    }

    // Convert Entity to DTO:-
    public static CategoryDTO toCategoryDTO(Category category){
        if(category == null){
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProductList().stream()
                .map(ProductMapper::toProductDTO)
                .toList());
        return categoryDTO;
    }
}

