package com.example.analyticsDaslhboardApi.service;

import com.example.analyticsDaslhboardApi.dto.RegionOrderVolumeDto;
import com.example.analyticsDaslhboardApi.dto.RegistrationStatsDto;
import com.example.analyticsDaslhboardApi.dto.TopProductDto;
import com.example.analyticsDaslhboardApi.repository.OrderRepository;
import com.example.analyticsDaslhboardApi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public List<RegistrationStatsDto> getDailyUserRegistrations(){
        LocalDate today = LocalDate.now();
        LocalDate sevenDaysAgo = today.minusDays(6);

        return userRepository.findAll().stream()
                .filter(user -> user.getRegisteredAt() != null)
                .filter(user -> user.getRegisteredAt().toLocalDate().isAfter(sevenDaysAgo.minusDays(1)))
                .collect(Collectors.groupingBy(
                        user -> user.getRegisteredAt().toLocalDate().toString(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .map(entry -> new RegistrationStatsDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public List<RegistrationStatsDto> getWeeklyUserRegistrations(){
        LocalDate startOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());

        return userRepository.findAll().stream()
                .filter(user -> user.getRegisteredAt() != null)
                .filter(user -> user.getRegisteredAt().toLocalDate().isAfter(startOfMonth.minusDays(1)))
                .collect(Collectors.groupingBy(
                        user -> "Week " + (user.getRegisteredAt().getDayOfMonth() / 7 + 1),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .map(entry -> new RegistrationStatsDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public List<RegionOrderVolumeDto> getOrderVolumeByRegion(){
        return orderRepository.getOrderVolumeByRegion();
    }

    public List<TopProductDto> getTop5OrderedProduct(){
        return orderRepository.getTop5Product(PageRequest.of(0 ,5));
    }
}
