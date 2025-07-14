package com.example.analyticsDaslhboardApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopProductDto {

    private String productName;
    private long totalOrdered;
}
