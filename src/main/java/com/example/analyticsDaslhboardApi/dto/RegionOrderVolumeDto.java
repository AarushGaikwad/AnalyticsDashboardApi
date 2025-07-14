package com.example.analyticsDaslhboardApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegionOrderVolumeDto {

    private String region;
    private long totalQuantity;
}
