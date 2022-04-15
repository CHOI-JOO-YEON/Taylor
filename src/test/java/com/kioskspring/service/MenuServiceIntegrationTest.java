package com.kioskspring.service;


import com.kioskspring.domain.Menu;
import com.kioskspring.menu.MemoryMenuRepository;
import com.kioskspring.menu.MenuRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class MenuServiceIntegrationTest {
    @Autowired
    MenuService menuService;
    @Autowired
    MenuRepository menuRepository;


    @Test
    public void 메뉴생성() throws Exception {
        Menu menu = new Menu();
        menu.setName("아메리카노");

        Long saveId = menuService.add(menu);

        Menu fineMenu = menuRepository.findById(saveId).get();

        assertEquals(menu.getName(), fineMenu.getName());
    }

    @Test
    public void 중복_메뉴_예외() throws Exception {
        Menu menu1 = new Menu();
        menu1.setName("아메리카노");
        menu1.setTemp("ICE");

        Menu menu2 = new Menu();
        menu2.setName("아메리카노");
        menu2.setTemp("ICE");

        menuService.add(menu1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> menuService.add(menu2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 메뉴입니다");

    }
}
