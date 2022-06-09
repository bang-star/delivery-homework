package com.example.delivery.service;

import com.example.delivery.dto.FoodRegisterRequestDto;
import com.example.delivery.dto.RestaurantRequestDto;
import com.example.delivery.model.Food;
import com.example.delivery.model.Restaurant;
import com.example.delivery.repository.FoodReposiotry;
import com.example.delivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final FoodReposiotry foodReposiotry;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, FoodReposiotry foodReposiotry) {
        this.restaurantRepository = restaurantRepository;
        this.foodReposiotry = foodReposiotry;
    }

    public Restaurant registerRestaurant(RestaurantRequestDto restaurantRequestDto) {
        // Save
        Restaurant restaurant = new Restaurant(restaurantRequestDto);
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Transactional
    public void registerFood(Long restaurantId, List<FoodRegisterRequestDto> foodList) {
        for(FoodRegisterRequestDto requestDto : foodList){
            registerFoodOrThrow(restaurantId, requestDto);
        }
    }

    private void registerFoodOrThrow(Long restaurantId, FoodRegisterRequestDto requestDto) {
        String name = requestDto.getName();

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 음식점 아이디입니다."));

        boolean isExistFood = foodReposiotry.existsByNameAndRestaurant(name, restaurant);

        if(isExistFood){
            throw new IllegalArgumentException("중복된 음식이 존재합니다. 음식명 : "+name);
        }

        Food food = new Food(restaurant, requestDto);
        foodReposiotry.save(food);
    }
}
