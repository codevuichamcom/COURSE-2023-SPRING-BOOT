package com.example.onlineshop.mapper;

import com.example.onlineshop.dto.ProductDTOResponse;
import com.example.onlineshop.entity.Product;

public class ProductMapper {
    public static ProductDTOResponse toProductDTOResponse(Product product) {
        return  ProductDTOResponse.builder().build();
    }
}
