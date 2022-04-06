package com.perscholas.catermate.controller;

import com.perscholas.catermate.model.Cart;
import com.perscholas.catermate.model.CartItem;
import com.perscholas.catermate.model.MenuItem;
import com.perscholas.catermate.service.CartItemService;
import com.perscholas.catermate.service.CartService;
import com.perscholas.catermate.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/cart")
    public String getAll(Model model) {
        model.addAttribute("listCarts", cartService.getAllCarts());
        return "cart";
    }

    @GetMapping("/showNewCartForm")
    public String showNewForm(Model model) {
        // create model attribute to bind form data
        Cart cart = new Cart();
        model.addAttribute("cart", cart);
        return "new_cart_item";
    }

    @PostMapping("/saveCart")
    public String save(@ModelAttribute("cart") Cart cart) {
        // save cart to database
        cartService.saveCart(cart);
        return "redirect:/cart";
    }

    @GetMapping("/showCartFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get cart from the service
        Cart cart = cartService.getCartById(id);

        // set cart as a model attribute to pre-populate the form
        model.addAttribute("cart", cart);
        return "update_cart_item";
    }

    @GetMapping("/deleteCart/{id}")
    public String delete(@PathVariable(value = "id") long id) {

        // call delete cart method
        this.cartService.deleteCartById(id);
        return "redirect:/cart";
    }

    @GetMapping("/addToCart/{cart_id}/{menu_item_id}")
    public String addToCart(
            @PathVariable(value="cart_id") long cartId,
            @PathVariable(value = "menu_item_id") long menuItemId,
            Model model) {

        System.out.println("adding item " + menuItemId + " to cart " + cartId);
        Cart cart = cartService.getCartById(cartId);

        MenuItem menuItem = menuItemService.getMenuItemById(menuItemId);

        CartItem cartItem = new CartItem(menuItem);
        cartItem.setQuantity(1);

        cart.getCartItemList().add(cartItem);

        cartItemService.saveCartItem(cartItem);
        cartService.saveCart(cart);

        return "redirect:/order/" + cartId;
    }
}
