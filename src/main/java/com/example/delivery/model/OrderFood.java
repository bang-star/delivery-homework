package com.example.delivery.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator(
        name = "ORDERFOOD_A",
        sequenceName = "ORDERFOOD_B",
        initialValue = 1, allocationSize = 50)
public class OrderFood {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERFOOD_A")
    @Column(name="ORDERFOOD_ID")
    private Long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="ORDER_ID", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name="FOOD_ID", nullable = false)
    private Food food;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Long price;


    public OrderFood(Food food, Long quantity, Long orderPrice) {
        this.food = food;
        this.quantity = quantity;
        this.price = orderPrice;
    }

}





