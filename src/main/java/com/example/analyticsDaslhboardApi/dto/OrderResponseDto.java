package com.example.analyticsDaslhboardApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

    private Long id;
    private String username;
    private String productName;
    private int quantity;
    private String region;
    private LocalDateTime orderedAt;
}
