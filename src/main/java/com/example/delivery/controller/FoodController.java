package com.example.delivery.controller;

import com.example.delivery.model.Food;
import com.example.delivery.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getAllFoods(@PathVariable Long restaurantId){
        return foodService.getAllFoods(restaurantId);
    }
}
