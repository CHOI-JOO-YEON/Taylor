package com.kioskspring.controller;

import com.kioskspring.domain.Menu;
import com.kioskspring.domain.Orders;
import com.kioskspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrderController {
    private final OrderService orderService;


    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("orders/list")
    public String list(Model model) {
        List<Orders> orders = orderService.findOrders();
        model.addAttribute("orders", orders);
        return "orders/orderList";
    }
}
