package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.CategoryDTOCreate;
import com.example.onlineshop.dto.CategoryDTOResponse;
import com.example.onlineshop.entity.Category;
import com.example.onlineshop.exception.OnlineShopException;
import com.example.onlineshop.mapper.CategoryMapper;
import com.example.onlineshop.repository.CategoryRepository;
import com.example.onlineshop.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;

    @Override
    public CategoryDTOResponse createCategory(CategoryDTOCreate categoryDTOCreate) {
        Category category = CategoryMapper.toCategory(categoryDTOCreate);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTOResponse(category);
    }

    @Override
    public List<CategoryDTOResponse> getAllCategory() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toCategoryDTOResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTOResponse getCategoryById(int id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(()-> OnlineShopException.notFound("Category does not exist"));
        return CategoryMapper.toCategoryDTOResponse(category);
    }
}
