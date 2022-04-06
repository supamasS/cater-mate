package org.supamassirichotiyakul.catermate.service;

import org.supamassirichotiyakul.catermate.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    void saveOrder(Order order);
    Order getOrderById(long id);
    void deleteOrderById(long id);
}
