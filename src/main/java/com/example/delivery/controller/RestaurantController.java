package com.example.delivery.controller;

import com.example.delivery.dto.FoodRegisterRequestDto;
import com.example.delivery.dto.FoodRequestDto;
import com.example.delivery.dto.RestaurantRequestDto;
import com.example.delivery.model.Restaurant;
import com.example.delivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(RestaurantRequestDto restaurantRequestDto){
        return restaurantService.registerRestaurant(restaurantRequestDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody FoodRequestDto requestDto){
        List<FoodRegisterRequestDto> foodList = requestDto.getFoodList();
        restaurantService.registerFood(restaurantId, foodList);
    }
}
