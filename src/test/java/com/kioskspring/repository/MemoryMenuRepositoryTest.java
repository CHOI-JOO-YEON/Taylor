package com.kioskspring.repository;

import com.kioskspring.domain.Menu;
import com.kioskspring.menu.MenuRepository;
import com.kioskspring.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemoryMenuRepositoryTest {

    @Autowired
    MenuRepository menuRepository;
    @Autowired
    MenuService menuService;

    @Test
    public void 메뉴추가() throws Exception {
        //given
        Menu menu = new Menu();
        menu.setName("아메리카노");
        menu.setTemp("ICE");
        //when
        Long saveId = menuService.add(menu);

        //then
        Menu findMenu = menuRepository.findById(saveId).get();

        System.out.println(menu + "-----------------");
        assertEquals(menu.getName(), findMenu.getName());

    }

    @Test
    public void 중복_메뉴_예외() throws Exception {

        //given
        Menu menu1 = new Menu();
        menu1.setName("아메리카노");
        menu1.setTemp("ICE");
        Menu menu2 = new Menu();
        menu2.setName("아메리카노");
        menu2.setTemp("ICE");

        //when
        menuService.add(menu1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> menuService.add(menu2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 메뉴입니다");

        //then
    }

}
