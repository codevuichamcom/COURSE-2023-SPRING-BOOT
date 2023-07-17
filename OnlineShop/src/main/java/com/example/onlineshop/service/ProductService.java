package com.example.onlineshop.service;

import com.example.onlineshop.dto.ProductDTOResponse;

import java.util.List;

public interface ProductService {
    List<ProductDTOResponse> getAllCategory();
}
