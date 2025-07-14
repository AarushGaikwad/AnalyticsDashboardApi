package com.example.analyticsDaslhboardApi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderRequestDto {

    private Long userId;
    private Long productId;
    private int quantity;
    private String region;
    private LocalDateTime orderedAt;
}
