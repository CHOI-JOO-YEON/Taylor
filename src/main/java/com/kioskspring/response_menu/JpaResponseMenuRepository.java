package com.kioskspring.response_menu;

import com.kioskspring.domain.Menu;
import com.kioskspring.domain.MenuRank;
import com.kioskspring.domain.ResponseMenu;
import com.kioskspring.service.MenuRankService;
import com.kioskspring.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JpaResponseMenuRepository implements ResponseMenuRepository{

    private final EntityManager em;

    public JpaResponseMenuRepository(EntityManager em) {
        this.em = em;
    }
    @Autowired
    MenuService menuService;

    @Autowired
    MenuRankService menuRankService;

    @Override
    public List<ResponseMenu> getResponse(int age, String gender) {
        HashMap<Integer,Integer> map = menuRankService.getSpecialRank(age, gender);


        String s = "total";

        if(age>=40)
        {
            s="old_";
        }else if(age<40)
        {
            s="young_";
        }

        if(gender.equals("male"))
        {
            s += "male";
        }else if(gender.equals("female"))
        {
            s += "female";
        }
        List<Menu> m = menuService.fineMenu();
        List<ResponseMenu> r = new ArrayList<>();
        for (int i = 0; i <m.size() ; i++) {
            ResponseMenu k = new ResponseMenu();
            k.setId(m.get(i).getId());
            k.setCategory(m.get(i).getCategory());
            k.setName(m.get(i).getName());
            k.setPrice(m.get(i).getPrice());
            k.setSales_status(m.get(i).getSales_status());
            k.setStock(m.get(i).getStock());
            k.setTemp(m.get(i).getTemp());
            k.setSequence(map.get(k.getId()));
            r.add(k);
        }
        return r;

    }
}
