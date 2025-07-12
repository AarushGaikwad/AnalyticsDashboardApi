package com.example.analyticsDaslhboardApi.repository;

import com.example.analyticsDaslhboardApi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
