package com.example.delivery.validator;

import com.example.delivery.dto.RestaurantRequestDto;
import org.springframework.stereotype.Component;

@Component
public class RestaurantValidator {

    public static void validateRestaurantInput(RestaurantRequestDto restaurantRequestDto) {
        Long minOrderPrice = restaurantRequestDto.getMinOrderPrice();
        Long deliveryFee = restaurantRequestDto.getDeliveryFee();

        validateMinOrderPrice(minOrderPrice);
        validatemDeliveryFee(deliveryFee);
    }

    private static void validatemDeliveryFee(Long deliveryFee) {
        if(!(deliveryFee >= 0 && deliveryFee <=10000)){
            throw new IllegalArgumentException("기본 배달비는 0원에서 10,000원 이하만 가능합니다.");
        }
        if(deliveryFee % 500 !=0 ){
            throw new IllegalArgumentException("기본 배달비는 500원 단위로 입력 가능합니다.");
        }
    }

    private static void validateMinOrderPrice(Long minOrderPrice) {
        if(!(minOrderPrice >= 1000 && minOrderPrice <= 100000)){
            throw new IllegalArgumentException("최소주문 가격은 1,000원 이상 100,000원 미만입니다.");
        }
        if(minOrderPrice % 100 != 0){
            throw new IllegalArgumentException("최소주문 가격은 100원 단위로만 입력가능합니다.");
        }
    }

}
