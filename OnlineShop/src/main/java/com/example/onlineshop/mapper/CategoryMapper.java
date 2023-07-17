package com.example.onlineshop.mapper;

import com.example.onlineshop.dto.CategoryDTOCreate;
import com.example.onlineshop.dto.CategoryDTOResponse;
import com.example.onlineshop.entity.Category;

public class CategoryMapper {
    public static Category toCategory(CategoryDTOCreate categoryDTOCreate) {
        return Category.builder()
                .categoryName(categoryDTOCreate.getCategoryName())
                .build();
    }

    public static CategoryDTOResponse toCategoryDTOResponse(Category category) {
        return CategoryDTOResponse.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .build();
    }
}
