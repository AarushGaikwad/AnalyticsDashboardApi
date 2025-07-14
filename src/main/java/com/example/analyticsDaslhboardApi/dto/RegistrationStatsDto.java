package com.example.analyticsDaslhboardApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationStatsDto {

    private String date;
    private long count;
}
