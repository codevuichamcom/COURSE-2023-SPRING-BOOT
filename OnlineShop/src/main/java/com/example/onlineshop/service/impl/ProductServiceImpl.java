package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.ProductDTOResponse;
import com.example.onlineshop.mapper.ProductMapper;
import com.example.onlineshop.repository.ProductCategory;
import com.example.onlineshop.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class ProductServiceImpl implements ProductService {
    ProductCategory productCategory;
    @Override
    public List<ProductDTOResponse> getAllCategory() {
        return productCategory.findAll().stream()
                .map(ProductMapper::toProductDTOResponse)
                .collect(Collectors.toList());
    }
}
