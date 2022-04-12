package org.supamassirichotiyakul.catermate.controller;

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



    // *** This is the MAIN page when http://localhost:8080
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

//    @GetMapping("/")
//    public String doLogin(Model model) {
//        return "redirect:/order";
//    }
//
//    @GetMapping("/user")
//    public String userIndex() {
//        return "user/index";
//    }
}
