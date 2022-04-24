package com.kioskspring.order;

import com.kioskspring.domain.Orders;

public interface OrderRepository {
    Orders save(Orders orders);
    int getTime(int startAge, int endAge, String gender, int orderMenu);



}
