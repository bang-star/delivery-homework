package com.example.delivery.repository;

import com.example.delivery.model.Food;
import com.example.delivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodReposiotry  extends JpaRepository<Food, Long> {
    boolean existsByNameAndRestaurant(String name, Restaurant restaurant);
    List<Food> findAllByRestaurant(Restaurant restaurant);
}
