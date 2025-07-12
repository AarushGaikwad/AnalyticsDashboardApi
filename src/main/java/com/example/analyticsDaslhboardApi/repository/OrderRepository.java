package com.example.analyticsDaslhboardApi.repository;

import com.example.analyticsDaslhboardApi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
