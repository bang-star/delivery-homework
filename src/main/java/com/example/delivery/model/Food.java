package com.example.delivery.model;

import com.example.delivery.dto.FoodRegisterRequestDto;
import com.example.delivery.validator.FoodValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Food {
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="RESTAURANT_ID", nullable = false)
    private Restaurant restaurant;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Long price;

    public Food(Restaurant restaurant, FoodRegisterRequestDto requestDto) {
        FoodValidator.validateFoodtInput(requestDto);

        this.restaurant  = restaurant;
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }
}
