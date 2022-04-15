package com.kioskspring.controller;

import com.kioskspring.domain.Menu;
import com.kioskspring.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MenuController {
    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping(value = "menus/new")
    public String createForm() {
        return "menus/createMenuForm";
    }

    @PostMapping(value = "/menus/new")
    public String create(MenuForm form) {
        Menu menu = new Menu();
        menu.setName(form.getName());
        menu.setTemp(form.getTemp());
        menu.setPrice(form.getPrice());
        menu.setStock(1000L);
        menu.setSales_status(true);
        menuService.add(menu);
        return "redirect:/";
    }

    @GetMapping(value = "/menus")
    public String list(Model model) {
        List<Menu> menus = menuService.fineMenu();
        model.addAttribute("menus", menus);
        return "menus/menuList";
    }



}
