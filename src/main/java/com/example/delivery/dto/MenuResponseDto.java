package com.example.delivery.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuResponseDto {
    private Long id;
    private String name;
    private Long price;

    public MenuResponseDto(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
