package com.edgars.CarShare.controllers;

import com.edgars.CarShare.models.User;
import com.edgars.CarShare.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
public class AppController {
    private UserService userServiceImpl;

    @Autowired
    public AppController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/index")
    public String index(Model model){
        return "index";
    }
    @GetMapping("/signup")
    public String showSignupForm(User user, Model model){

        model.addAttribute("user", user);
        return "add-user";
    }

    @PostMapping("/add-user")
    public String saveUser(@ModelAttribute("user") User user){
        userServiceImpl.addUser(user);
        return "redirect:/car/car-list";
    }
    @GetMapping("/user-list")
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public String allUsers(Model model){
        List<User> userList = userServiceImpl.showAllUsers();
        model.addAttribute("userList", userList);
        return "user-list";
    }
    //PreAuthorize("hasRole('ROLE_') hasAnyRole(ROLE_) hasAuthority(permission), hasAnyAuthority('permission')
    @GetMapping("/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteAllUsers(){
        userServiceImpl.deleteAllUsers();
        return "redirect:/user-list";
    }
    @GetMapping("/deleteUser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteUser(@RequestParam("UserId") Long id){
        userServiceImpl.deleteUser(id);
        return "redirect:/user-list";
    }
}
