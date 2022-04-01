package com.perscholas.catermate.controller;

import com.perscholas.catermate.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuItemController {
    private MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping("/menuitems")
    public String getAllEmployees(Model model) {
        model.addAttribute("listMenuItems", menuItemService.getAllMenuItems());
        return "order";
    }
}
