package com.example.delivery.model;

import com.example.delivery.dto.RestaurantRequestDto;
import com.example.delivery.validator.RestaurantValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator(
        name = "RESTAURANT_A",
        sequenceName = "RESTAURANT_B",
        initialValue = 1, allocationSize = 50)
public class Restaurant {
    // ID가 자동으로 생성 및 증가합니다.
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "RESTAURANT_A")
    @Column(name = "RESTAURANT_ID")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Long minOrderPrice;

    @Column(nullable = false)
    private Long deliveryFee;

    public Restaurant(RestaurantRequestDto restaurantRequestDto) {
        // validation
        RestaurantValidator.validateRestaurantInput(restaurantRequestDto);

        this.name = restaurantRequestDto.getName();
        this.minOrderPrice = restaurantRequestDto.getMinOrderPrice();
        this.deliveryFee = restaurantRequestDto.getDeliveryFee();
    }
}
