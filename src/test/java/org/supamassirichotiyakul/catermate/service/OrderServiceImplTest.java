package org.supamassirichotiyakul.catermate.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.supamassirichotiyakul.catermate.model.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    @Test
    @Transactional
    void getAllOrdersShouldReturnCorrectResultList() {
        // act and assert
        List<Order> allOrders = orderService.getAllOrders();
        int beforeAddingMoreOrders = allOrders.size();

        Assertions.assertThat(beforeAddingMoreOrders).isEqualTo(0);

        Order order = new Order();
        order.setCustomerFirstName("Sam");
        order.setCustomerLastName("Smith");
        order.setDeliveryAddress("22 Main St., Chandler, AZ 85333");
        order.setCustomerPhone("480-222-4444");
        order.setDeliveryOption("Deliver");
        order.setLocation("Mesa");
        order.setDeliveryDate(new Date());
        order.setKitchenReadyTime(new Date());
        order.setOrderItemList(new ArrayList<>());

        orderService.saveOrder(order);
        int afterAddingMoreOrders = orderService.getAllOrders().size();

        Assertions.assertThat(afterAddingMoreOrders).isEqualTo(beforeAddingMoreOrders + 1);
        Assertions.assertThat(allOrders.contains(order));
    }

//    @Test
//    @Transactional
//    void saveOrderShouldSaveToTable() {
//        List<Order> allOrders = orderService.getAllOrders();
//        int beforeAddingMoreOrders = allOrders.size();
//
//        Order order1 = new Order();
//        order1.setName("Horchata");
//        order1.setPrice(3.5);
//        orderService.saveOrder(order1);
//
//        int afterAddingMoreOrders = orderService.getAllOrders().size();
//
//        Assertions.assertThat(afterAddingMoreOrders).isEqualTo(beforeAddingMoreOrders + 1);
//        Assertions.assertThat(allOrders.contains(order1));
//    }
//
//    @Test
//    @Transactional
//    void getOrderByIdShouldReturnCorrectOrder() {
//        // act and assert
//        Order expected = new Order();
//        expected.setName("Horchata");
//        expected.setPrice(3.5);
//        orderService.saveOrder(expected);
//
//        Order actual = orderService.getOrderById(expected.getId());
//
//        Assertions.assertThat(actual).isEqualTo(expected);
//    }
//
//    @Test
//    @Transactional
//    void deleteOrderByIdShouldDeleteFromTable() {
//        // act and assert
//        Order expected = new Order();
//        expected.setName("Horchata");
//        expected.setPrice(3.5);
//        orderService.saveOrder(expected);
//
//        List<Order> allOrders = orderService.getAllOrders();
//        int beforeDeletingOrder = allOrders.size();
//
//        orderService.deleteOrderById(expected.getId());
//
//        Assertions.assertThat(orderService.getAllOrders().size()).isEqualTo(beforeDeletingOrder-1);
//    }
}
