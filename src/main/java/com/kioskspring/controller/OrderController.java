package com.kioskspring.controller;

import com.kioskspring.domain.Menu;
import com.kioskspring.domain.Orders;
import com.kioskspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class OrderController {
    private final OrderService orderService;
    EntityManager entityManager;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "orders/new")
    public String createForm() {
        return "orders/createOrderForm";
    }

    @PostMapping(value = "/orders/new")
    public String create(OrderForm form) {
        Orders orders = new Orders();
        orders.setOrderId(orderService.getMaxId());
        orders.setMenuId(form.getMenuId());
        orders.setValue(form.getValue());
        orders.setAge(form.getAge());
        orders.setGender(form.getGender());
        orders.setOrderTime(new Timestamp(System.currentTimeMillis()));
        System.out.println(new Timestamp(System.currentTimeMillis()));
        orderService.add(orders);
        return "redirect:/";
    }
    @GetMapping("orders/list")
    public String list(Model model) {
        List<Orders> orders = orderService.findOrders();
        model.addAttribute("orders", orders);
        return "orders/orderList";
    }
}
