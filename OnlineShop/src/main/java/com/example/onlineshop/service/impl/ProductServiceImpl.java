package com.example.onlineshop.service.impl;

import com.example.onlineshop.dto.PagingDTOResponse;
import com.example.onlineshop.dto.ProductDTOFilter;
import com.example.onlineshop.dto.ProductDTOResponse;
import com.example.onlineshop.mapper.ProductMapper;
import com.example.onlineshop.repository.criteria.ProductRepositoryCriteria;
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
    ProductRepositoryCriteria productRepositoryCriteria;
    @Override
    public PagingDTOResponse searchProduct(ProductDTOFilter productDTOFilter) {
        return productRepositoryCriteria.search(productDTOFilter);
    }
}
