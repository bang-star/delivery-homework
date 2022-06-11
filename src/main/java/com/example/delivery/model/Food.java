package com.example.delivery.model;

import com.example.delivery.dto.FoodRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@Table(
        uniqueConstraints={
                @UniqueConstraint( name="UNIQUE_FOOD",
                        columnNames = {"RESTAURANT_ID", "name"}
                )
        }
)
@SequenceGenerator(
        name = "FOOD_A",
        sequenceName = "FOOD_B",
        initialValue = 1, allocationSize = 50)
public class Food {
    // ID가 자동으로 생성 및 증가합니다.
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "FOOD_A")
    @Column(name="FOOD_ID")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;

    @ManyToOne
    @JoinColumn(name="RESTAURANT_ID", nullable = false)
    private Restaurant restaurant;

    public Food(Restaurant restaurant, FoodRequestDto requestDto) {
        this.restaurant  = restaurant;
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }
}
