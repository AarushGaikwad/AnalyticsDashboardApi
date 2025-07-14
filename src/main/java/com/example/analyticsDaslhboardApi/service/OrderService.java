package com.example.analyticsDaslhboardApi.service;

import com.example.analyticsDaslhboardApi.dto.OrderRequestDto;
import com.example.analyticsDaslhboardApi.dto.OrderResponseDto;
import com.example.analyticsDaslhboardApi.entity.Order;
import com.example.analyticsDaslhboardApi.entity.Product;
import com.example.analyticsDaslhboardApi.entity.User;
import com.example.analyticsDaslhboardApi.repository.OrderRepository;
import com.example.analyticsDaslhboardApi.repository.ProductRepository;
import com.example.analyticsDaslhboardApi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderResponseDto createOrder(OrderRequestDto dto){
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setQuantity(dto.getQuantity());
        order.setRegion(dto.getRegion());
        order.setOrderedAt(dto.getOrderedAt());

        Order saved = orderRepository.save(order);
        return new OrderResponseDto(
                saved.getId(),
                user.getName(),
                product.getName(),
                saved.getQuantity(),
                saved.getRegion(),
                saved.getOrderedAt()
        );
    }

    public List<OrderResponseDto> getAllOrders(){
        return orderRepository.findAll().stream()
                .map(o ->new OrderResponseDto(
                        o.getId(),
                        o.getUser().getName(),
                        o.getProduct().getName(),
                        o.getQuantity(),
                        o.getRegion(),
                        o.getOrderedAt()
                ))
                .collect(Collectors.toList());
    }

    public OrderResponseDto getOrderById(Long id) {
        Order o = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return new OrderResponseDto(
                o.getId(),
                o.getUser().getName(),
                o.getProduct().getName(),
                o.getQuantity(),
                o.getRegion(),
                o.getOrderedAt()
        );
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found");
        }
        orderRepository.deleteById(id);
    }
}
