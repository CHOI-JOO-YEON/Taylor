package com.kioskspring.order;

import com.kioskspring.domain.Orders;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Orders save(Orders orders);
    long getTime(int startAge, int endAge, String gender, int orderMenu);
    List<Orders> findAll();



}
