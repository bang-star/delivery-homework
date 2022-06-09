package com.example.delivery.service;

import com.example.delivery.dto.OrderFoodRequestDto;
import com.example.delivery.dto.OrderReuestDto;
import com.example.delivery.model.Food;
import com.example.delivery.model.OrderFood;
import com.example.delivery.model.Restaurant;
import com.example.delivery.repository.OrderRepository;
import com.example.delivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, RestaurantRepository restaurantRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<OrderFood> requestOrder(OrderReuestDto requestDto) {
        Long restaurantId = requestDto.getRestaurantId();
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않은 음식점 ID입니다."));

        List<OrderFoodRequestDto> orderFoodList = requestDto.getOrderFoodList();

    }
}
