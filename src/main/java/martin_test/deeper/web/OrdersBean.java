package martin_test.deeper.web;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import martin_test.deeper.entities.Orders;

import java.util.List;

@RequestScoped
@Named
public class OrdersBean {

    @PersistenceContext(unitName = "default")
    EntityManager em;

    public List<Orders> getOrders() {
        TypedQuery<Orders> orderList = em.createNamedQuery("orders.selectAll", Orders.class);
        return orderList.getResultList();
    }

    public Orders create(Orders order) {
        em.persist(order);
        return order;
    }

    public void deleteOrder(int id) {
        TypedQuery<Orders> orderList = em.createNamedQuery("orders.remove", Orders.class);
        orderList.setParameter("id", id);
        orderList.executeUpdate();
    }
}