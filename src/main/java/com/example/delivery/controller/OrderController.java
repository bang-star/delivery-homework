package com.example.delivery.controller;


import com.example.delivery.dto.OrderReuestDto;
import com.example.delivery.model.OrderFood;
import com.example.delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/request")
    public List<OrderFood> requestOrder(@RequestBody OrderReuestDto reuestDto){
        return orderService.requestOrder(reuestDto);
    }

}
