package com.example.delivery.validator;

import com.example.delivery.dto.FoodRegisterRequestDto;
import org.springframework.stereotype.Component;

@Component
public class FoodValidator {

    public static void validateFoodtInput(FoodRegisterRequestDto restaurantRequestDto) {
        Long price = restaurantRequestDto.getPrice();

        validatePrice(price);
    }

    private static void validatePrice(Long price) {
        if(!(price >= 100 && price <= 1_000_000)){
            throw new IllegalArgumentException("음식 가격은 100원에서 1,000,000원 이하만 가능합니다.");
        }
        if(price % 100 !=0 ){
            throw new IllegalArgumentException("음식 가격은 100원 단위로 입력 가능합니다.");
        }
    }
}
