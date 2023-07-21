package com.example.onlineshop.mapper;

import com.example.onlineshop.dto.ProductDTOResponse;
import com.example.onlineshop.entity.Product;

public class ProductMapper {
    public static ProductDTOResponse toProductDTOResponse(Product product) {
        return  ProductDTOResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .summary(product.getSummary())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .availability(product.getAvailability())
                .specification(product.getSpecification())
                .category(CategoryMapper.toCategoryDTOResponse(product.getCategory()))
                .build();
    }
}
