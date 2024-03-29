package com.kioskspring;

import com.kioskspring.menu.JpaMenuRepository;
import com.kioskspring.menu.MenuRepository;
import com.kioskspring.menu_rank.JpaMenuRankRepository;
import com.kioskspring.menu_rank.MenuRankRepository;
import com.kioskspring.order.JpaOrderRepository;
import com.kioskspring.order.OrderRepository;
import com.kioskspring.response_menu.JpaResponseMenuRepository;
import com.kioskspring.response_menu.ResponseMenuRepository;
import com.kioskspring.service.MenuRankService;
import com.kioskspring.service.MenuService;
import com.kioskspring.service.OrderService;
import com.kioskspring.service.ResponseMenuService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private EntityManager entityManager;

    public SpringConfig(DataSource dataSource, EntityManager entityManager) {
        this.dataSource = dataSource;
        this.entityManager = entityManager;
    }


    @Bean
    public MenuService menuService() {
        return new MenuService(menuRepository());
    }

    @Bean
    public MenuRepository menuRepository() {

        return new JpaMenuRepository(entityManager);
    }

    @Bean
    public OrderService orderService() {
        return new OrderService(orderRepository());
    }

    @Bean
    public OrderRepository orderRepository() {
        return new JpaOrderRepository(entityManager);
    }

    @Bean
    public MenuRankService menuRankService() {
        return new MenuRankService(menuRankRepository());
    }

    @Bean
    public MenuRankRepository menuRankRepository() {
        return new JpaMenuRankRepository(entityManager);
    }

    @Bean
    ResponseMenuService responseMenuService() {
        return new ResponseMenuService(responseMenuRepository());
    }

    @Bean
    ResponseMenuRepository responseMenuRepository() {
        return new JpaResponseMenuRepository(entityManager);
    }

}
