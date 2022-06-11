package com.example.delivery.controller;

import com.example.delivery.dto.FoodRequestDto;
import com.example.delivery.dto.MenuResponseDto;
import com.example.delivery.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodRequestDto> requestDto){
        foodService.registerFood(restaurantId, requestDto);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<MenuResponseDto> getAllFoods(@PathVariable Long restaurantId){
        return foodService.getAllFoods(restaurantId);
    }

}
