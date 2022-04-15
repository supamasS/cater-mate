package org.supamassirichotiyakul.catermate.controller;

import org.springframework.web.bind.annotation.*;
import org.supamassirichotiyakul.catermate.model.Cart;
import org.supamassirichotiyakul.catermate.model.Order;
import org.supamassirichotiyakul.catermate.model.QueryObj;
import org.supamassirichotiyakul.catermate.service.CartService;
import org.supamassirichotiyakul.catermate.service.OrderItemService;
import org.supamassirichotiyakul.catermate.service.OrderService;
import org.supamassirichotiyakul.catermate.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

@Controller
public class OrderController {
    private OrderService orderService;
    private MenuItemService menuItemService;
    private OrderItemService orderItemService;
    private CartService cartService;

    @Autowired
    public OrderController(OrderService orderService,
                           MenuItemService menuItemService,
                           OrderItemService orderItemService,
                           CartService cartService) {
        this.orderService = orderService;
        this.menuItemService = menuItemService;
        this.orderItemService = orderItemService;
        this.cartService = cartService;
    }

    @GetMapping("/viewOrders")
    public String getAll(Model model) {
        model.addAttribute("listOrders", orderService.getAllOrders());
        model.addAttribute("queryObj", new QueryObj());
        return "view_orders";
    }

//    @PostMapping("/saveOrder")
//    public String save(@ModelAttribute("order") Order order) {
//        // save order to database
//        orderService.saveOrder(order);
//        return "redirect:/order";
//    }

    @GetMapping("/showOrderFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        // get order from the service
        Order order = orderService.getOrderById(id);

        // set order as a model attribute to pre-populate the form
        model.addAttribute("order", order);
        model.addAttribute("itemList", order.getOrderItemList());

        return "update_order";
    }

    @GetMapping("/deleteOrder/{id}")
    public String delete(@PathVariable(value = "id") long id) {
        // call delete order method
        this.orderService.deleteOrderById(id);
        return "redirect:/viewOrders";
    }

    @GetMapping("/order")
    public String doOrder(Model model) {
        Cart cart = new Cart();
        cartService.saveCart(cart); // need to save to create a new id

        model.addAttribute("listMenuItems", menuItemService.getAllMenuItems());
        model.addAttribute("cart", cart);

//        System.out.println("----- custom query 1 -----");
//        orderService.findByCustomerFirstNameOrCustomerLastNameContaining("am").forEach(o ->  System.out.println(o.toString()));
//
//        System.out.println("----- custom query 2 -----");
//        try {
//            orderService.findByDeliveryDateEquals(new SimpleDateFormat
//                    ("yyyy-MM-dd").parse("2022-04-16")).forEach(o ->  System.out.println(o.toString()));
//        } catch (ParseException e) {
//            System.out.println("Error parsing date");
//            e.printStackTrace();
//        }
//
//        System.out.println("----- custom query 3 -----");
//        orderService.findByLocationContaining("Gilbert").forEach(o -> System.out.println(o.toString()));

        return "order";
    }

    @GetMapping("/checkout/{cart_id}")
    public String doCheckOut(@PathVariable(value="cart_id") long cartId, Model model) {
        Cart cart = cartService.getCartById(cartId);

        model.addAttribute("cart", cart);
        model.addAttribute("itemList", cart.getCartItemList());

        Order order = new Order();
        model.addAttribute("order", order);

        return "checkout";
    }

    @PostMapping("/orderSubmitted")
    public String doOrderSubmitted(
            @RequestParam(name="cart_id", required=true) int cartId,
            @ModelAttribute("order") Order order) {
        Cart cart = cartService.getCartById(cartId);

        orderService.copyInfoFromCart(order, cart);

        orderService.saveOrder(order);

        return "order_submitted";
    }

    // This is from when the order was updated, no need to copy the cart items to order items
    @PostMapping("/updateOrder")
    public String updateOrder(@ModelAttribute("order") Order order) {
        orderService.saveOrder(order);

        return "order_submitted";
    }

    @PostMapping("/findOrders")
    public String findOrders(@ModelAttribute QueryObj queryObj, Model model) {
        System.out.println("qName is " + queryObj.getQueryName());

        Set<Order> orderSet = new HashSet<>();

        if(!queryObj.getQueryName().isEmpty()) {
            String name = queryObj.getQueryName();
            orderSet.addAll(orderService.findByCustomerFirstNameContainingOrCustomerLastNameContaining(name, name));
        }

        if(!queryObj.getQueryLocation().isEmpty()){
            orderSet.addAll(orderService.findByLocationContaining(queryObj.getQueryLocation()));
        }

        if(queryObj.getQueryDeliveryDate() != null){
            orderSet.addAll(orderService.findByDeliveryDateEquals(queryObj.getQueryDeliveryDate()));
        }

        model.addAttribute("listOrders", orderSet);
        model.addAttribute("queryObj", new QueryObj());

        return "view_orders";
    }
}
