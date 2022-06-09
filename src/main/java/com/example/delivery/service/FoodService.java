package com.example.delivery.service;

import com.example.delivery.model.Food;
import com.example.delivery.model.Restaurant;
import com.example.delivery.repository.FoodReposiotry;
import com.example.delivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    private final FoodReposiotry foodReposiotry;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public FoodService(FoodReposiotry foodReposiotry, RestaurantRepository restaurantRepository) {
        this.foodReposiotry = foodReposiotry;
        this.restaurantRepository = restaurantRepository;
    }

    public List<Food> getAllFoods(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 레스토랑 Id입니다."));

        return foodReposiotry.findAllByRestaurant(restaurant);
    }
}
