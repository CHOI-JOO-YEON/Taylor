package com.kioskspring.servlet.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
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
@WebServlet(name = "responseJsonMenuServlet", urlPatterns = "/response-json")
public class ResponseJsonMenuServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    private final MenuService menuService;

    public ResponseJsonMenuServlet(MenuService menuService) {
        this.menuService = menuService;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        List<Menu> menuList = menuService.fineMenu();
        String json = new Gson().toJson(menuList);
        response.getWriter().write(json);
    }
}
