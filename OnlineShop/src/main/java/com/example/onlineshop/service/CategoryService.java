package com.example.onlineshop.service;

import com.example.onlineshop.dto.CategoryDTOCreate;
import com.example.onlineshop.dto.CategoryDTOResponse;

import java.util.List;

public interface CategoryService {
    CategoryDTOResponse createCategory(CategoryDTOCreate categoryDTOCreate);

    List<CategoryDTOResponse> getAllCategory();

    CategoryDTOResponse getCategoryById(int id);
}
