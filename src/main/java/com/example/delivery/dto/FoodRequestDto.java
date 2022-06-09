package com.example.delivery.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class FoodRequestDto {
    List<FoodRegisterRequestDto> foodList;
}
