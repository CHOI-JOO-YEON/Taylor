package com.kioskspring.servlet.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.kioskspring.domain.Menu;
import com.kioskspring.domain.Orders;
import com.kioskspring.service.OrderService;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@WebServlet(name = "responseJsonOrderServlet",urlPatterns = "/response-order")
public class ResponseJsonOrderServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    private final OrderService orderService;

    public ResponseJsonOrderServlet(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        List<Orders> ordersList = orderService.findOrders();
        String json = new Gson().toJson(ordersList);
        response.getWriter().write(json);
    }
}
