package com.kioskspring.menu;

import com.kioskspring.domain.Menu;

import javax.persistence.EntityManager;
import java.util.*;

public class MemoryMenuRepository implements MenuRepository{


    private static Map<Long, Menu> cafe = new HashMap<>();


    private static long sequence = 0L;


    @Override
    public Menu save(Menu menu) {
        menu.setId(++sequence);
        cafe.put(menu.getId(), menu);
        return null;
    }

    @Override
    public Optional<Menu> findById(Long id) {

        return Optional.ofNullable(cafe.get(id));
    }

    @Override
    public Optional<Menu> findByName(String name, String temp) {
        return cafe.values().stream().filter(menu -> menu.getName().equals(name)&&menu.getTemp().equals(temp)).findAny();
    }

    @Override
    public List<Menu> findAll() {
        return new ArrayList<>(cafe.values());

    }
    public void clearCafe(){
        cafe.clear();
    }
}
