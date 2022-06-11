package com.kioskspring.servlet.response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kioskspring.domain.Orders;
import com.kioskspring.service.MenuRankService;
import com.kioskspring.service.OrderService;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;

@CrossOrigin
@WebServlet(name = "responseJsonOrderServlet", urlPatterns = "/response-order")
public class ResponseJsonOrderServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    private final OrderService orderService;
    private final MenuRankService menuRankService;

    public ResponseJsonOrderServlet(OrderService orderService, MenuRankService menuRankService) {
        this.orderService = orderService;
        this.menuRankService = menuRankService;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        ServletInputStream inputStream = request.getInputStream();

        List<tempOrder> tempOrders = objectMapper.readValue(inputStream, new TypeReference<List<tempOrder>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });


        Timestamp timestamp = new Timestamp(System.currentTimeMillis());


        int age = tempOrders.get(0).age;
        String gender = tempOrders.get(0).gender;
        int id = orderService.getMaxId();
        for (tempOrder tempOrder : tempOrders) {
            Orders order = new Orders();
            order.setOrderTime(timestamp);
            order.setOrderId(id);
            order.setGender(gender.toUpperCase(Locale.ROOT));
            order.setAge(age);
            order.setMenuId(tempOrder.id);
            order.setValue(tempOrder.num);
            orderService.add(order);
        }
        String ageGender;
        if(age>=15&&age<=45)
        {
            ageGender="young";
        }else
        {
            ageGender="old";
        }

        if(gender.equals("male"))
        {
            ageGender+="Male";
        }else{
            gender+="Female";
        }

        menuRankService.setRank(ageGender);





    }
}

class tempOrder {
    String name;
    int price;
    int num;
    String temp;
    String category;
    int id;
    int age;
    String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
