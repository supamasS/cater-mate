package com.perscholas.catermate.controller;

import com.perscholas.catermate.service.MenuItemService;
import com.perscholas.catermate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private UserService userService;
    private MenuItemService menuItemService;

    @Autowired
    public MainController(UserService userService, MenuItemService menuItemService) {
        this.userService = userService;
        this.menuItemService = menuItemService;
    }

    @GetMapping("/")
    public String doLogin(Model model) {
        return "index";
    }

    @GetMapping("/order")
    public String doOrder(Model model) {
        model.addAttribute("listMenuItems", menuItemService.getAllMenuItems());
        return "order";
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable(value = "id") long id, Model model) {
//        model.addAttribute("listMenuItems", menuItemService.getAllMenuItems());
        System.out.println("adding item with id = " + id + " to cart");
        return "redirect:/order";
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
