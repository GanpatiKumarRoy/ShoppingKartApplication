package com.ganpati.product.service;

import com.ganpati.product.dto.CategoryDTO;
import com.ganpati.product.entity.Category;
import com.ganpati.product.exception.CategoryAlreadyExistsException;
import com.ganpati.product.exception.CategoryNotFoundException;
import com.ganpati.product.mapper.CategoryMapper;
import com.ganpati.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Optional<Category> existedCategory = categoryRepository.findByName(categoryDTO.getName());
        if(existedCategory.isPresent()){
            throw new CategoryAlreadyExistsException("Category " + categoryDTO.getName() + " already exists");
        }
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    public List<CategoryDTO> findAllCategories(){
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    public CategoryDTO findCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category id " + id + " not exists!"));
        return CategoryMapper.toCategoryDTO(category);
    }

    public String deleteCategoryById(Long id){
        categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category id " + id + " not exists!"));
        categoryRepository.deleteById(id);
        return "Category " + id + " has been deleted!";
    }
}