package com.ganpati.shoppingkart.dto;

import java.util.List;

// Not using lombok manually creating the code.

public class CategoryDTO {

    private Long id;
    private String name;
    private List<ProductDTO> products;

    // No-args constructor (equivalent to @NoArgsConstructor)
    public CategoryDTO() {
    }

    // All-args constructor (equivalent to @AllArgsConstructor)
    public CategoryDTO(Long id, String name, List<ProductDTO> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}