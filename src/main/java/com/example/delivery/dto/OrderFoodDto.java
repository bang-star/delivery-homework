package com.example.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderFoodDto {
    //foodId
    private Long id;

    //foodName
    private String name;

    //주문 갯수
    private Long quantity;

    //주문 가격
    private Long price;




}
