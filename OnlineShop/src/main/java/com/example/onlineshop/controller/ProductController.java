package com.example.onlineshop.controller;

import com.example.onlineshop.dto.CategoryDTOResponse;
import com.example.onlineshop.dto.ProductDTOResponse;
import com.example.onlineshop.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.onlineshop.util.Constant.API_VERSION;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(API_VERSION + "/products")
public class ProductController {
    ProductService productService;

    @GetMapping()
    public List<ProductDTOResponse> getAllProduct() {
        return productService.getAllCategory();
    }
}
