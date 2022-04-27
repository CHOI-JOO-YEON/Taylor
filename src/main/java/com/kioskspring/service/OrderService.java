package com.kioskspring.service;

import com.kioskspring.domain.Orders;
import com.kioskspring.order.OrderRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public long getTime(int startAge,int endAge, String gender,int orderMenu) {
        return orderRepository.getTime(startAge, endAge, gender, orderMenu);
    }

    public List<Orders> findOrders() {
        return orderRepository.findAll();
    }
}
