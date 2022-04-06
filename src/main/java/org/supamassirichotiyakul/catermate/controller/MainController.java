package org.supamassirichotiyakul.catermate.controller;

import org.supamassirichotiyakul.catermate.service.CartService;
import org.supamassirichotiyakul.catermate.service.MenuItemService;
import org.supamassirichotiyakul.catermate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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




//    @GetMapping("/goodbye")
//    public String goodbye(@RequestParam(name="name", required=false, defaultValue="Universe") String name,
//                          Model model) {
//        model.addAttribute("name", name);
//        return "goodbye";
//    }
//
}
