package com.kioskspring.domain;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "orders")
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderKey;
    private int orderId;
    private int orderValue;
    private int orderMenu;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:MI:SS")
    private Date orderDate;
    private int age;
    private String gender;


    public int getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(int orderKey) {
        this.orderKey = orderKey;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(int orderValue) {
        this.orderValue = orderValue;
    }

    public int getOrderMenu() {
        return orderMenu;
    }

    public void setOrderMenu(int id) {
        this.orderMenu = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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
