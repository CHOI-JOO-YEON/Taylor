package com.kioskspring.order;

import com.kioskspring.domain.Orders;

import javax.persistence.EntityManager;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public long getTime(int startAge, int endAge, String gender, int orderMenu) {
        LocalDate now = LocalDate.now();
        LocalDate pre = now.minusDays(10);

        Timestamp timestampS = Timestamp.valueOf(LocalDate.now().toString()+" 23:59:59");
        Timestamp timestampE = Timestamp.valueOf(LocalDate.now().minusDays(10).toString()+" 00:00:00");

        long result = 0L;
        Long temp = 0L;
        if (gender.equals("UNKNOWN")) {
            temp = em.createQuery("select sum(o.value) from Orders o where o.orderTime between :end and :start " +
                                    "and o.age between :startAge and :endAge and o.menuId = :orderMenu"
                            , Long.class).setParameter("startAge", startAge).setParameter("endAge", endAge).
                    setParameter("orderMenu", orderMenu).setParameter("end", timestampE).setParameter("start", timestampS).getSingleResult();

        } else {
            temp = em.createQuery("select sum(o.value) from Orders o where o.orderTime between :end and :start" +
                            " and o.age between :startAge and :endAge and o.menuId = :orderMenu and " +
                            "o.gender = :gender  ", Long.class).setParameter("startAge", startAge).setParameter("endAge", endAge).
                    setParameter("orderMenu", orderMenu).setParameter("gender", gender).
                    setParameter("end", timestampE).setParameter("start", timestampS).getSingleResult();

        }

        result = temp == null ? 0L : temp;

        return result;
    }

    @Override
    public List<Orders> findAll() {
        return em.createQuery("select o from Orders o", Orders.class).getResultList();
    }

    @Override
    public int getMaxId() {
        int temp = em.createQuery("select max(o.orderId)from Orders o ", Integer.class).getSingleResult();


        return temp + 1;
    }
}
