package com.perscholas.catermate.controller;

import com.perscholas.catermate.model.Cart;
import com.perscholas.catermate.service.CartService;
import com.perscholas.catermate.service.MenuItemService;
import com.perscholas.catermate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    private UserService userService;
    private MenuItemService menuItemService;
    private CartService cartService;


    @Autowired
    public MainController(UserService userService, MenuItemService menuItemService, CartService cartService) {
        this.userService = userService;
        this.menuItemService = menuItemService;
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String doLogin(Model model) {
        return "index";
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

    @GetMapping("/order_submitted")
    public String doOrderSubmitted() {

        return "order_submitted";
    }

//    @GetMapping("/goodbye")
//    public String goodbye(@RequestParam(name="name", required=false, defaultValue="Universe") String name,
//                          Model model) {
//        model.addAttribute("name", name);
//        return "goodbye";
//    }
//
}
