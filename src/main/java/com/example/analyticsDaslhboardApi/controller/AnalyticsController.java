package com.example.analyticsDaslhboardApi.controller;

import com.example.analyticsDaslhboardApi.dto.RegionOrderVolumeDto;
import com.example.analyticsDaslhboardApi.dto.RegistrationStatsDto;
import com.example.analyticsDaslhboardApi.dto.TopProductDto;
import com.example.analyticsDaslhboardApi.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/users/daily")
    public List<RegistrationStatsDto> getDailyRegistrations(){
        return analyticsService.getDailyUserRegistrations();
    }

    @GetMapping("/users/weekly")
    public List<RegistrationStatsDto> getWeeklyRegistrations(){
        return analyticsService.getWeeklyUserRegistrations();
    }

    @GetMapping("/orders/region")
    public List<RegionOrderVolumeDto> getOrderVolumeByRegion(){
        return analyticsService.getOrderVolumeByRegion();
    }

    @GetMapping("/top-product")
    public List<TopProductDto> getTopProducts(){
        return analyticsService.getTop5OrderedProduct();
    }
}
