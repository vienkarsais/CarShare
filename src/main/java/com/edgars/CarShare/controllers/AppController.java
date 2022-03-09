package com.edgars.CarShare.controllers;

import com.edgars.CarShare.models.User;
import com.edgars.CarShare.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class AppController {
    private UserService userServiceImpl;

    @Autowired
    public AppController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }
    @GetMapping("/signup")
    public String showSignupForm(User user, Model model){

        model.addAttribute("user", user);
        return "add-user";
    }

    @PostMapping("/add-user")
    public String saveUser(@ModelAttribute("employee") User user){
        userServiceImpl.addUser(user);
        return "redirect:/car/car-list";
    }
    @GetMapping("/user-list")
    public String allUsers(Model model){
        List<User> userList = userServiceImpl.showAllUsers();
        model.addAttribute("userList", userList);
        return "user-list";
    }
}
