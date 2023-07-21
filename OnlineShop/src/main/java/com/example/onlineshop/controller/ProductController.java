package com.example.onlineshop.controller;

import com.example.onlineshop.dto.CategoryDTOResponse;
import com.example.onlineshop.dto.PagingDTOResponse;
import com.example.onlineshop.dto.ProductDTOFilter;
import com.example.onlineshop.dto.ProductDTOResponse;
import com.example.onlineshop.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.onlineshop.util.Constant.API_VERSION;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(API_VERSION + "/products")
public class ProductController {
    ProductService productService;

    @GetMapping("/search")
    public PagingDTOResponse searchProduct(@ModelAttribute ProductDTOFilter productDTOFilter) {
        return productService.searchProduct(productDTOFilter);
    }
}
