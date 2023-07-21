package com.example.onlineshop.service;

import com.example.onlineshop.dto.PagingDTOResponse;
import com.example.onlineshop.dto.ProductDTOFilter;
import com.example.onlineshop.dto.ProductDTOResponse;

import java.util.List;

public interface ProductService {
    PagingDTOResponse searchProduct(ProductDTOFilter productDTOFilter);
}
