package com.kioskspring.service;

import com.kioskspring.domain.Menu;
import com.kioskspring.menu.MenuRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public Integer add(Menu menu) {
        validateDuplicateMenu(menu);
        menuRepository.save(menu);
        return menu.getId();
    }

    private void validateDuplicateMenu(Menu menu) {
        menuRepository.findByName(menu.getName(), menu.getTemp()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 메뉴입니다");
        });

    }

    public List<Menu> fineMenu() {
        return menuRepository.findAll();
    }

    public Optional<Menu> findOne(int menuId){
        return menuRepository.findById(menuId);
    }
}
