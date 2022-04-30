package com.kioskspring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MenuRank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int menuId;
    int total;
    int youngMale;
    int youngFemale;
    int oldMale;

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getYoungMale() {
        return youngMale;
    }

    public void setYoungMale(int youngMale) {
        this.youngMale = youngMale;
    }

    public int getYoungFemale() {
        return youngFemale;
    }

    public void setYoungFemale(int youngFemale) {
        this.youngFemale = youngFemale;
    }

    public int getOldMale() {
        return oldMale;
    }

    public void setOldMale(int oldMale) {
        this.oldMale = oldMale;
    }

    public int getOldFemale() {
        return oldFemale;
    }

    public void setOldFemale(int oldFemale) {
        this.oldFemale = oldFemale;
    }

    int oldFemale;

}
