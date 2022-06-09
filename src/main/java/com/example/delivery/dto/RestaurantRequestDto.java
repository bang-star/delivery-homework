package com.example.delivery.dto;

import lombok.Getter;

@Getter
public class RestaurantRequestDto {
    private String name;
    private Long minOrderPrice;
    private Long deliveryFee;

}
