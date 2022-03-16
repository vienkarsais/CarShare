package com.edgars.CarShare.controllers;

import com.edgars.CarShare.models.User;
import com.edgars.CarShare.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private UserService userServiceImpl;

    @Autowired
    public LoginController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        return "login";
    }

    @GetMapping("/signup")
    public String showSignupForm(User user, Model model){

        model.addAttribute("user", user);
        return "add-user";
    }
}
