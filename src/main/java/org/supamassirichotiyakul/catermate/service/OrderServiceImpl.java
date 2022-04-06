package org.supamassirichotiyakul.catermate.service;

import org.supamassirichotiyakul.catermate.exception.OrderNotFoundException;
import org.supamassirichotiyakul.catermate.model.Order;
import org.supamassirichotiyakul.catermate.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order getOrderById(long id) {
        Order order = orderRepository.getById(id);
        if(order == null) {
            throw new OrderNotFoundException();
        }
        return order;
    }

    @Override
    public void deleteOrderById(long id) {
        orderRepository.deleteById(id);
    }
}
