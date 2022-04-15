package com.kioskspring.menu;

import com.kioskspring.domain.Menu;

import java.util.List;
import java.util.Optional;

public interface MenuRepository {
    Menu save(Menu menu);
    Optional<Menu> findById(int id);
    Optional<Menu> findByName(String name,String temp);
    List<Menu> findAll();

}
