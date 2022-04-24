package com.kioskspring.order;

import com.kioskspring.domain.Orders;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaOrderRepository implements OrderRepository {
    private final EntityManager em;

    public JpaOrderRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Orders save(Orders orders) {
        em.persist(orders);
        return orders;
    }

    @Override
    public int getTime(int startAge, int endAge, String gender, int orderMenu) {
        List<Orders> result = em.createQuery("select o from Orders o",Orders.class).getResultList();

//        List<Orders> result = em.createQuery("select sum(o.orderValue) from Orders o where o.age between :startAge and :endAge and o.orderMenu = :orderMenu and " +
//                "o.gender = :gender  ",Orders.class).setParameter("startAge", startAge).setParameter("endAge", endAge).
//                setParameter("orderMenu", orderMenu).setParameter("gender", gender).getResultList();
        System.out.println(result);
        System.out.println(em.createQuery("select o.orderId from Orders o",Orders.class).getResultList());

        return 0;
    }
}
