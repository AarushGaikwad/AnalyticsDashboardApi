package com.example.analyticsDaslhboardApi.controller;

import com.example.analyticsDaslhboardApi.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public void getDailyRegistrations(){

    }

    public void getWeeklyRegistrations(){

    }

    public void getOrderVolumeByRegion(){

    }

    public void getTopProducts(){
        
    }
}
