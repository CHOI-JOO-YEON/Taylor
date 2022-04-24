package com.kioskspring.repository;

import com.kioskspring.domain.Orders;
import com.kioskspring.order.OrderRepository;
import com.kioskspring.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderRepositoryTest {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;



    @Test
    public void checkOrderTime() {
        int time = orderService.getTime(20,30,"MALE",1);
        System.out.println(time);

    }

}
