package com.example.delivery.service;

import com.example.delivery.dto.RestaurantRequestDto;
import com.example.delivery.model.Restaurant;
import com.example.delivery.repository.FoodReposiotry;
import com.example.delivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public Restaurant registerRestaurant(RestaurantRequestDto restaurantRequestDto) {
        // Save
        Boolean result = restaurantRepository.existsByName(restaurantRequestDto.getName());
        if(result){ throw new IllegalArgumentException("이미 존재하는 음식점 이름입니다."); }

        Restaurant restaurant = new Restaurant(restaurantRequestDto);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return savedRestaurant;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }


}
