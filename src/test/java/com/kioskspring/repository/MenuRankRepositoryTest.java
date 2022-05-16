package com.kioskspring.repository;

import com.kioskspring.domain.MenuRank;
import com.kioskspring.menu_rank.JpaMenuRankRepository;
import com.kioskspring.menu_rank.MenuRankRepository;
import com.kioskspring.order.OrderRepository;
import com.kioskspring.service.MenuRankService;
import com.kioskspring.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
@Transactional
public class MenuRankRepositoryTest {
    @Autowired
    MenuRankService menuRankService;
    @Autowired
    MenuRankRepository menuRankRepository;

    @Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepository;
    @Test
    public void checkList() {
        List<MenuRank> m = menuRankService.getRank();
        for (MenuRank menuRank : m) {
            System.out.println(menuRank.getMenuId());
        }
    }
    @Test
    public void menuRankReset() {
        menuRankService.resetRank();
    }

    @Test
    public void setRank() {
        menuRankService.setRank("youngMale");
    }
    
    @Test
    public void totalRank() {
        List<MenuRank> menuRanks= menuRankService.totalRank();
        for (MenuRank menuRank : menuRanks) {
            System.out.println(menuRank.getMenuId() + " " +menuRank.getTotal());
        }
    }
    @Test
    public void specialRank() {
        HashMap<Integer, Integer> result = new HashMap<>();
        result= menuRankService.getSpecialRank(25,"male");
        System.out.println("result = " + result);


    }
}
