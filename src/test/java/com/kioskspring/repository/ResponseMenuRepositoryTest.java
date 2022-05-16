package com.kioskspring.repository;


import com.kioskspring.domain.ResponseMenu;
import com.kioskspring.response_menu.ResponseMenuRepository;
import com.kioskspring.service.ResponseMenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ResponseMenuRepositoryTest {
    @Autowired
    ResponseMenuService responseMenuService;

    @Autowired
    ResponseMenuRepository responseMenuRepository;

    @Test
    void check() {
        List<ResponseMenu> s =responseMenuService.findResponse(25, "male");
        for (ResponseMenu responseMenu : s) {
            System.out.println(responseMenu.getId()+", "+responseMenu.getName()+ "," +responseMenu.getSequence());
        }
    }
}
