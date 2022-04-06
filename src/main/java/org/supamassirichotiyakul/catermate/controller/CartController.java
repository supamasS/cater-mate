package org.supamassirichotiyakul.catermate.controller;

import org.supamassirichotiyakul.catermate.model.Cart;
import org.supamassirichotiyakul.catermate.model.CartItem;
import org.supamassirichotiyakul.catermate.model.MenuItem;
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

    @PostMapping("/addToCart/{cart_id}/{menu_item_id}")
    public String addToCart(
            @PathVariable(value="cart_id") long cartId,
            @PathVariable(value = "menu_item_id") long menuItemId,
            @ModelAttribute("cart") Cart modelCart,
            BindingResult bindingResult,
            Model model) {

        System.out.println("adding item " + menuItemId + " to cart " + cartId + " and " + modelCart.getId());
        Cart cart = cartService.getCartById(cartId);

        MenuItem menuItem = menuItemService.getMenuItemById(menuItemId);

        CartItem cartItem = new CartItem(cart, menuItem);

        System.out.println("quantity = " + modelCart.getCurrentItemQuantity());

        cartItem.setQuantity(modelCart.getCurrentItemQuantity());

        cart.getCartItemList().add(cartItem);

        System.out.println("In cart controller");
        cart.getCartItemList().forEach(i -> System.out.println(i.getName() + " " + i.getQuantity()));

        cartItemService.saveCartItem(cartItem);
        cartService.saveCart(cart);

        return "redirect:/orderCart/" + cartId;
    }

    @GetMapping("/orderWithCart")
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
}