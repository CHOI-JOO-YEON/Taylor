package com.kioskspring.servlet.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kioskspring.domain.Menu;
import com.kioskspring.service.MenuService;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    MenuService menuService;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type: application/json
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        Menu menu = new Menu();
        menu.setSales_status(true);
        menu.setPrice(1000L);
        menu.setTemp("HOT");
        menu.setName("아메리카노");
        menu.setStock(1000L);
        menu.setId(1);

        String result = objectMapper.writeValueAsString(menu);
        System.out.println("result = " + result);
        response.getWriter().write(result);


    }
}
