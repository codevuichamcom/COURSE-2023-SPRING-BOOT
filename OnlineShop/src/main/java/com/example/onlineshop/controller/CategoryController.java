package com.example.onlineshop.controller;


import com.example.onlineshop.dto.CategoryDTOCreate;
import com.example.onlineshop.dto.CategoryDTOResponse;
import com.example.onlineshop.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.onlineshop.util.Constant.API_VERSION;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(API_VERSION + "/categories")
public class CategoryController {
    CategoryService categoryService;

    @PostMapping()
    public CategoryDTOResponse createCategory(@RequestBody CategoryDTOCreate categoryDTOCreate) {
        return categoryService.createCategory(categoryDTOCreate);
    }

    @GetMapping()
    public List<CategoryDTOResponse> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryDTOResponse getCategoryById(@PathVariable int id) {
        return categoryService.getCategoryById(id);
    }
}
