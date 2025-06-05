package com.ganpati.product.service;

import com.ganpati.product.dto.CategoryDTO;
import com.ganpati.product.entity.Category;
import com.ganpati.product.mapper.CategoryMapper;
import com.ganpati.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    public List<CategoryDTO> findAllCategories(){
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    public CategoryDTO findCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found!"));
        return CategoryMapper.toCategoryDTO(category);
    }

    public String deleteCategoryById(Long id){
        categoryRepository.deleteById(id);
        return "Category " + id + " has been deleted!";
    }
}