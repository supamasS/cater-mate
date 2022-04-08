package org.supamassirichotiyakul.catermate.controller;

import org.springframework.web.bind.annotation.*;
import org.supamassirichotiyakul.catermate.model.Cart;
import org.supamassirichotiyakul.catermate.model.Order;
import org.supamassirichotiyakul.catermate.service.CartService;
import org.supamassirichotiyakul.catermate.service.OrderItemService;
import org.supamassirichotiyakul.catermate.service.OrderService;
import org.supamassirichotiyakul.catermate.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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



    @GetMapping("/showNewOrderForm")
    public String showNewForm(Model model) {
        // create model attribute to bind form data
        Order order = new Order();
        model.addAttribute("order", order);
        return "new_order_item";
    }

    @PostMapping("/saveOrder")
    public String save(@ModelAttribute("order") Order order) {
        // save order to database
        orderService.saveOrder(order);
        return "redirect:/order";
    }

    @GetMapping("/showOrderFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get order from the service
        Order order = orderService.getOrderById(id);

        // set order as a model attribute to pre-populate the form
        model.addAttribute("order", order);
        return "update_order_item";
    }

    @GetMapping("/deleteOrder/{id}")
    public String delete(@PathVariable(value = "id") long id) {

        // call delete order method
        this.orderService.deleteOrderById(id);
        return "redirect:/order";
    }

    @GetMapping("/order")
    public String doOrder(Model model) {
        Cart cart = new Cart();
        cartService.saveCart(cart); // need to save to create a new id??

        model.addAttribute("listMenuItems", menuItemService.getAllMenuItems());
        model.addAttribute("cart", cart);

        return "order";
    }

    @GetMapping("/checkout/{cart_id}")
    public String doCheckOut(@PathVariable(value="cart_id") long cartId, Model model) {
        Cart cart = cartService.getCartById(cartId);

        model.addAttribute("cart", cart);

        Order order = new Order();
        model.addAttribute("order", order);

        return "checkout";
    }

    @PostMapping("/order_submitted")
    public String doOrderSubmitted(
            @RequestParam(name="cart_id", required=true) int cartId,
            @ModelAttribute("order") Order order) {
        Cart cart = cartService.getCartById(cartId);

        orderService.copyInfoFromCart( order, cart);

        orderService.saveOrder(order);

        return "order_submitted";
    }
}
