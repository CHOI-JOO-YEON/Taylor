package com.kioskspring.service;

import com.kioskspring.order.OrderRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public int getTime(int startAge,int endAge, String gender,int orderMenu) {
        return orderRepository.getTime(startAge, endAge, gender, orderMenu);
    }
}
