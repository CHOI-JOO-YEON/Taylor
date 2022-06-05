package com.kioskspring.menu_rank;

import com.kioskspring.domain.MenuRank;
import com.kioskspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.*;

public class JpaMenuRankRepository implements MenuRankRepository {
    @Autowired
    OrderService orderService;

    private final EntityManager entityManager;

    public JpaMenuRankRepository(EntityManager entityManager) {
        this.entityManager = entityManager;

    }


    @Override
    public void resetRank() {
        List<MenuRank> result = entityManager.createQuery("select mR from MenuRank mR", MenuRank.class).getResultList();
        for (MenuRank menuRank : result) {
            int n = menuRank.getMenuId();
            menuRank.setYoungMale(n);
            menuRank.setYoungFemale(n);
            menuRank.setOldMale(n);
            menuRank.setOldFemale(n);
            menuRank.setTotal(n);
        }


    }

    @Override
    public void setRank(String ageGender) {

        List<MenuRank> result = entityManager.createQuery("select mR from MenuRank mR", MenuRank.class).getResultList();
        int startAge = 0;
        int endAge = 100;
        String gender = "UNKNOWN";

        switch (ageGender)
        {
            case "youngMale":
                endAge = 40;
                gender = "MALE";
                break;
            case "youngFemale":
                endAge = 40;
                gender = "FEMALE";
                break;
            case "oleMale":
                startAge = 41;
                gender = "MALE";
                break;
            case "oldFemale":
                startAge = 41;
                gender = "FEMALE";
                break;
        }


        int finalStartAge = startAge;
        int finalEndAge = endAge;
        String finalGender = gender;
        Collections.sort(result, new Comparator<MenuRank>() {

            @Override
            public int compare(MenuRank o1, MenuRank o2) {
                if (orderService.getTime(finalStartAge, finalEndAge, finalGender, o1.getMenuId())
                        < orderService.getTime(finalStartAge, finalEndAge, finalGender, o2.getMenuId())) {
                    return 1;
                } else if (orderService.getTime(finalStartAge, finalEndAge, finalGender, o1.getMenuId())
                        > orderService.getTime(finalStartAge, finalEndAge, finalGender, o2.getMenuId())) {
                    return -1;
                } else {
                    return 0;

                }

            }
        });
        int target = 0;

        switch (ageGender)
        {
            case "youngMale":
                for (int i = 1; i < result.size(); i++) {
                    result.get(target++).setYoungMale(i);

                }
                break;
            case "youngFemale":
                for (int i = 1; i < result.size(); i++) {
                    result.get(target++).setYoungFemale(i);

                }
                break;
            case "oleMale":
                for (int i = 1; i < result.size(); i++) {
                    result.get(target++).setOldMale(i);

                }
                break;
            case "oldFemale":
                for (int i = 1; i < result.size(); i++) {
                    result.get(target++).setOldFemale(i);

                }
                break;
        }
        totalRank();
    }

    @Override
    public List<MenuRank> totalRank() {
        List<MenuRank> result = entityManager.createQuery("select mR from MenuRank mR", MenuRank.class).getResultList();


        Collections.sort(result, new Comparator<MenuRank>() {
            @Override
            public int compare(MenuRank o1, MenuRank o2) {
                if (orderService.getTime(0, 100, "UNKNOWN", o1.getMenuId())
                        < orderService.getTime(0, 100, "UNKNOWN", o2.getMenuId())) {
                    return 1;
                } else if (orderService.getTime(0, 100, "UNKNOWN", o1.getMenuId())
                        > orderService.getTime(0, 100, "UNKNOWN", o2.getMenuId())) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int target = 0;
        for (int i = 1; i < result.size(); i++) {
            result.get(target++).setTotal(i);

        }
        return result;
    }


    @Override
    public List<MenuRank> getRank() {
        return entityManager.createQuery("select mR from MenuRank mR", MenuRank.class).getResultList();
    }

    @Override
    public HashMap<Integer, Integer> getSpecialRank(int age, String gender) {
        String s = "total";

        if(age>=40)
        {
            s="old";
        }else if(age<40)
        {
            s="young";
        }

        if(gender.equals("male"))
        {
            s += "Male";
        }else if(gender.equals("female"))
        {
            s += "Female";
        }
        HashMap<Integer,Integer> result = new HashMap<>();
        Long max = entityManager.createQuery("select count(mR)from MenuRank mR",Long.class).getResultList().get(0);


        for (int i = 1; i <= max ; i++) {
            int temp = entityManager.createQuery("select mR.youngMale from MenuRank mR where mR.menuId = :i",Integer.class).setParameter("i",i).getSingleResult();
            //온도가 높을 때, 온도가 낮을 때, 비가 올 때, 눈이 올 때
            //아침, 점심, 밤
            result.put(i, temp);

        }


        return result;

    }
}
