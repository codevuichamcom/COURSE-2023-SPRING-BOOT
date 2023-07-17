package com.example.onlineshop.repository;

import com.example.onlineshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategory extends JpaRepository<Product, Integer> {
}
