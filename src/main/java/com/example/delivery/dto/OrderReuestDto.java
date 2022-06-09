package com.example.delivery.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderReuestDto {
    Long restaurantId;
    List<OrderFoodRequestDto> orderFoodList;
}
