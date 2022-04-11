package org.supamassirichotiyakul.catermate.controller;

import org.supamassirichotiyakul.catermate.model.Cart;
import org.supamassirichotiyakul.catermate.service.CartItemService;
import org.supamassirichotiyakul.catermate.service.CartService;
import org.supamassirichotiyakul.catermate.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {
    private CartService cartService;
    private MenuItemService menuItemService;
    private CartItemService cartItemService;

    @Autowired
    public CartController(CartService cartService, MenuItemService menuItemService, CartItemService cartItemService) {
        this.cartService = cartService;
        this.menuItemService = menuItemService;
        this.cartItemService = cartItemService;
    }

//    @GetMapping("/cart")
//    public String getAll(Model model) {
//        model.addAttribute("listCarts", cartService.getAllCarts());
//        return "cart";
//    }
//
//    @GetMapping("/showNewCartForm")
//    public String showNewForm(Model model) {
//        // create model attribute to bind form data
//        Cart cart = new Cart();
//        model.addAttribute("cart", cart);
//        return "new_cart_item";
//    }
//
//    @PostMapping("/saveCart")
//    public String save(@ModelAttribute("cart") Cart cart) {
//        // save cart to database
//        cartService.saveCart(cart);
//        return "redirect:/cart";
//    }
//
//    @GetMapping("/showCartFormForUpdate/{id}")
//    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
//
//        // get cart from the service
//        Cart cart = cartService.getCartById(id);
//
//        // set cart as a model attribute to pre-populate the form
//        model.addAttribute("cart", cart);
//        return "update_cart_item";
//    }
//
//    @GetMapping("/deleteCart/{id}")
//    public String delete(@PathVariable(value = "id") long id) {
//
//        // call delete cart method
//        this.cartService.deleteCartById(id);
//        return "redirect:/cart";
//    }

    @PostMapping("/addToCart/{menu_item_id}")
    public String addToCart(
            @PathVariable(value = "menu_item_id") long menuItemId,
            @ModelAttribute("cart") Cart cart,
            BindingResult bindingResult,
            Model model) {

        cartService.addMenuItemToCartById(cart, menuItemId);

        cartService.saveCart(cart);

        model.addAttribute("listMenuItems", menuItemService.getAllMenuItems());
//        model.addAttribute("cart", cart); // already in the model

        return "order";
    }


}
