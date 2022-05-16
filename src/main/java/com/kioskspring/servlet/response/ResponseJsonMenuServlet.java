package com.kioskspring.servlet.response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kioskspring.domain.Orders;
import com.kioskspring.domain.ResponseMenu;
import com.kioskspring.service.ResponseMenuService;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


class TempReq {
    int age;
    String gender;
}

@CrossOrigin
@WebServlet(name = "responseJsonMenuServlet", urlPatterns = "/response-json")

public class ResponseJsonMenuServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();


    private final ResponseMenuService responseMenuService;

    public ResponseJsonMenuServlet(ResponseMenuService responseMenuService) {
        this.responseMenuService = responseMenuService;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
//

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        List<ResponseMenu> list = responseMenuService.findResponse(age, gender);
        String json = new Gson().toJson(list);
        response.getWriter().write(json);
    }
}
