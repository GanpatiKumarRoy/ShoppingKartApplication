package com.ganpati.product.service;

import com.ganpati.product.dto.CategoryDTO;
import com.ganpati.product.entity.Category;
import com.ganpati.product.mapper.CategoryMapper;
import com.ganpati.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }
}