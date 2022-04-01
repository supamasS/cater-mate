package com.perscholas.catermate.controller;

import com.perscholas.catermate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllEmployees(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/order")
    public String doOrder() {
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
//    @GetMapping("/cohort/java")
//    public String goodbye(@RequestParam(name="topic", required=false, defaultValue="Spring") String topic,
//                          @RequestParam(name="week", required=false, defaultValue="1") String week,
//                          Model model) {
//        model.addAttribute("topic", topic);
//        model.addAttribute("week", week);
//        return "cohortinfo";
//    }
}