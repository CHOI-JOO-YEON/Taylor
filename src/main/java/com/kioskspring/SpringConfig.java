package com.kioskspring;

import com.kioskspring.menu.JpaMenuRepository;
import com.kioskspring.menu.MenuRepository;
import com.kioskspring.service.MenuService;
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
}