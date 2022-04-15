package com.kioskspring.menu;

import com.kioskspring.domain.Menu;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMenuRepository implements MenuRepository {
    private final EntityManager entityManager;

    public JpaMenuRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Menu save(Menu menu) {
        entityManager.persist(menu);
        return menu;
    }

    @Override
    public Optional<Menu> findById(int id) {
        Menu menu = entityManager.find(Menu.class, id);
        return Optional.ofNullable(menu);
    }

    @Override
    public Optional<Menu> findByName(String name, String temp) {
        List<Menu> result = entityManager.createQuery("select m from Menu m where m.name = :name and m.temp = :temp", Menu.class)
                .setParameter("name", name).setParameter("temp", temp).getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Menu> findAll() {
        return entityManager.createQuery("select m from Menu m",Menu.class)
                .getResultList();
    }
}
