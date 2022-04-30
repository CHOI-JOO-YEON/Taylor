package com.kioskspring.servlet.request;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kioskspring.domain.Menu;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@CrossOrigin
@WebServlet(name = "requestJsonOrderServlet", urlPatterns = "/request-json")
public class RequestJsonOrderServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();


        List<Menu> menuList =  objectMapper.readValue(inputStream, new TypeReference<List<Menu>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });

    }
}
