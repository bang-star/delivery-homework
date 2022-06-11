package com.example.delivery.controller;

import com.example.delivery.dto.OrderDto;
import com.example.delivery.dto.OrderResponseDto;
import com.example.delivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public OrderResponseDto createOrder(@RequestBody OrderDto requestDto){
        return orderService.createOrder(requestDto);

    }

    @GetMapping("/orders")
    public List<OrderResponseDto> findAllOrder(){
        return orderService.findAllOrder();
    }
}
