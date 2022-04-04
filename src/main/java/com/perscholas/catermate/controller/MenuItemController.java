package com.perscholas.catermate.controller;

import com.perscholas.catermate.model.MenuItem;
import com.perscholas.catermate.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MenuItemController {
    private MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping("/menu")
    public String getAllEmployees(Model model) {
        model.addAttribute("listMenuItems", menuItemService.getAllMenuItems());
        return "menu";
    }

    @GetMapping("/showNewMenuItemForm")
    public String showNewMenuItemForm(Model model) {
        // create model attribute to bind form data
        MenuItem menuItem = new MenuItem();
        model.addAttribute("menuItem", menuItem);
        return "new_menu_item";
    }

    @PostMapping("/saveMenuItem")
    public String saveEmployee(@ModelAttribute("employee") MenuItem menuItem) {
        // save employee to database
        menuItemService.saveMenuItem(menuItem);
        return "redirect:/menu";
    }

    @GetMapping("/showMenuItemFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get menuItem from the service
        MenuItem menuItem = menuItemService.getMenuItemById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("menuItem", menuItem);
        return "update_menu_item";
    }

    @GetMapping("/deleteMenuItem/{id}")
    public String delete(@PathVariable(value = "id") long id) {

        // call delete menuItem method
        this.menuItemService.deleteMenuItemById(id);
        return "redirect:/menuItems";
    }
}
