package com.example.delivery.service;

import com.example.delivery.dto.FoodRequestDto;
import com.example.delivery.dto.MenuResponseDto;
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
public class FoodService {
    private final FoodReposiotry foodReposiotry;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public FoodService(FoodReposiotry foodReposiotry, RestaurantRepository restaurantRepository) {
        this.foodReposiotry = foodReposiotry;
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public List<MenuResponseDto> getAllFoods(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 레스토랑 Id입니다."));

        List<Food> foods = foodReposiotry.findAllByRestaurant(restaurant);
        List<MenuResponseDto> menuList = new ArrayList<>();

        for(Food food : foods){
            Long id = food.getId();
            String name = food.getName();
            Long price = food.getPrice();
            MenuResponseDto menu = new MenuResponseDto(id, name, price);
            menuList.add(menu);
        }
        return menuList;
    }

    @Transactional
    public void registerFood(Long restaurantId, List<FoodRequestDto> foodList) {
        for(FoodRequestDto requestDto : foodList){
            registerFoodOrThrow(restaurantId, requestDto);
        }
    }

    private void registerFoodOrThrow(Long restaurantId, FoodRequestDto requestDto) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 음식점 아이디입니다."));

        Long price = requestDto.getPrice();

        if(!(price >= 100 && price <= 1_000_000)){
            throw new IllegalArgumentException("음식 가격은 100원에서 1,000,000원 이하만 가능합니다.");
        }
        if(price % 100 !=0 ){
            throw new IllegalArgumentException("음식 가격은 100원 단위로 입력 가능합니다.");
        }

        Food food = foodReposiotry.save(new Food(restaurant, requestDto));
    }
}
