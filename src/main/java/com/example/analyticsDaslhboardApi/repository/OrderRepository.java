package com.example.analyticsDaslhboardApi.repository;

import com.example.analyticsDaslhboardApi.dto.RegionOrderVolumeDto;
import com.example.analyticsDaslhboardApi.dto.TopProductDto;
import com.example.analyticsDaslhboardApi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT new com.example.analyticsdashboard.dto.RegionOrderVolumeDTO(o.region, SUM(o.quantity)) " +
            "FROM Order o GROUP BY o.region")

    List<RegionOrderVolumeDto> getOrderVolumeByRegion();

    @Query("SELECT new com.example.analyticsdashboard.dto.TopProductDTO(p.name, SUM(o.quantity)) " +
            "FROM Order o JOIN o.product p GROUP BY p.name ORDER BY SUM(o.quantity) DESC LIMIT 5")
    List<TopProductDto> getTop5Product();
}
