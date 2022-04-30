package com.kioskspring.menu_rank;

import com.kioskspring.domain.MenuRank;

import java.util.List;


public interface MenuRankRepository {
    void resetRank();
    void setRank(String ageGender);
    List<MenuRank> totalRank();
    List<MenuRank> getRank();


}
