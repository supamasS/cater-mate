package org.supamassirichotiyakul.catermate.controller;

import org.supamassirichotiyakul.catermate.model.Cart;
import org.supamassirichotiyakul.catermate.model.Order;
import org.supamassirichotiyakul.catermate.service.CartService;
import org.supamassirichotiyakul.catermate.service.OrderItemService;
import org.supamassirichotiyakul.catermate.service.OrderService;
import org.supamassirichotiyakul.catermate.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/order")
    public String doOrder(Model model) {
        Cart cart = new Cart();
        cartService.saveCart(cart);

        model.addAttribute("listMenuItems", menuItemService.getAllMenuItems());
        model.addAttribute("cart", cart);
        model.addAttribute("listCartItems", cart.getCartItemList());

        return "order";
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

    @GetMapping("/orderCart/{cart_id}")
    public String doOrderWithCart(
            @PathVariable(value="cart_id") long cartId,
            Model model) {
        model.addAttribute("listMenuItems", menuItemService.getAllMenuItems());

        Cart cart = cartService.getCartById(cartId);
        model.addAttribute("cart", cart);

        model.addAttribute("listCartItems", cart.getCartItemList());

//        System.out.println("In main controller");
//
//        cart.getCartItemList().forEach(i -> System.out.println(i.getName() + " " + i.getQuantity()));

        return "order";
    }

    @GetMapping("/checkout/{cart_id}")
    public String doCheckOut(@PathVariable(value="cart_id") long cartId, Model model) {
        Cart cart = cartService.getCartById(cartId);

        model.addAttribute("cart", cart);
        model.addAttribute("listCartItems", cart.getCartItemList());

        return "checkout";
    }

    @GetMapping("/order_submitted")
    public String doOrderSubmitted() {

        return "order_submitted";
    }


//    @PostMapping("/addToOrder/{order_id}/{menu_item_id}")
//    public String addToOrder(
//            @PathVariable(value="order_id") long orderId,
//            @PathVariable(value = "menu_item_id") long menuItemId,
//            @ModelAttribute("order") Order modelOrder,
//            BindingResult bindingResult,
//            Model model) {
//
//        System.out.println("adding item " + menuItemId + " to order " + orderId + " and " + modelOrder.getId());
//        Order order = orderService.getOrderById(orderId);
//
//        MenuItem menuItem = menuItemService.getMenuItemById(menuItemId);
//
//        OrderItem orderItem = new OrderItem(order, menuItem);
//
//        System.out.println("quantity = " + modelOrder.getCurrentItemQuantity());
//
//        orderItem.setQuantity(modelOrder.getCurrentItemQuantity());
//
//        order.getOrderItemList().add(orderItem);
//
//        System.out.println("In order controller");
//        order.getOrderItemList().forEach(i -> System.out.println(i.getName() + " " + i.getQuantity()));
//
//        orderItemService.saveOrderItem(orderItem);
//        orderService.saveOrder(order);
//
//        return "redirect:/orderOrder/" + orderId;
//    }

//    @GetMapping("/orderWithOrder")
//    public String doOrderWithOrder(
//            @PathVariable(value="order_id") long orderId,
//            Model model) {
//        model.addAttribute("listMenuItems", menuItemService.getAllMenuItems());
//
//        Order order = orderService.getOrderById(orderId);
//        model.addAttribute("order", order);
//
//        model.addAttribute("listOrderItems", order.getOrderItemList());
//
////        System.out.println("In main controller");
////
////        order.getOrderItemList().forEach(i -> System.out.println(i.getName() + " " + i.getQuantity()));
//
//        return "order";
//    }
}
