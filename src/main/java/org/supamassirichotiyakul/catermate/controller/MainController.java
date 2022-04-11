package org.supamassirichotiyakul.catermate.controller;

import org.supamassirichotiyakul.catermate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    // TODO May or may not need this constructor
//    private UserService userService;
//
//    @Autowired
//    public MainController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping("/")
    public String doLogin(Model model) {
        return "index";
    }
}
