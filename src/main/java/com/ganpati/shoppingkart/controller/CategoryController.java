package com.ganpati.shoppingkart.controller;

import com.ganpati.shoppingkart.dto.CategoryDTO;
import com.ganpati.shoppingkart.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(
        name = "Category API CRUD Operation",
        description = "CREATE, READ, UPDATE and DELETE operations for Category API"
)
@RestController
@RequestMapping("/kart-api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Create new category:-
    @Operation(
            summary = "Create new category",
            description = "Rest API to create new category"
    )
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    // Get all available categories:-
    @Operation(
            summary = "Fetch all category",
            description = "Rest API to fetch all category"
    )
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        return new ResponseEntity<>(categoryService.findAllCategories(), HttpStatus.FOUND);
    }

    // Get category by ID:-
    @Operation(
            summary = "Fetch category by ID",
            description = "Rest API to fetch category by ID"
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findCategoryById(id), HttpStatus.FOUND);
    }

    // Delete categories by ID:-
    @Operation(
            summary = "Delete category by ID",
            description = "Rest API to delete category by ID"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.deleteCategoryById(id), HttpStatus.OK);
    }
}