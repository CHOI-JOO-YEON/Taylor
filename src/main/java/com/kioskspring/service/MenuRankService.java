package com.kioskspring.service;

import com.kioskspring.domain.MenuRank;
import com.kioskspring.menu_rank.MenuRankRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class MenuRankService {
    private final MenuRankRepository menuRankRepository;

    public MenuRankService(MenuRankRepository menuRankRepository) {
        this.menuRankRepository = menuRankRepository;
    }

    public void resetRank() {
        menuRankRepository.resetRank();
    }

    public void setRank(String ageGender) {
        menuRankRepository.setRank(ageGender);
    }

    public List<MenuRank> getRank() {
       return menuRankRepository.getRank();
    }

    public List<MenuRank> totalRank() {return menuRankRepository.totalRank();}
}
