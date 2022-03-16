package com.edgars.CarShare.controllers;

import com.edgars.CarShare.models.User;
import com.edgars.CarShare.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {
    private UserService userServiceImpl;

    @Autowired
    public UserController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/add")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result){
        if (result.hasErrors()){
            return "redirect:/add-user";
        }
        userServiceImpl.addUser(user);
        return "redirect:/car/car-list";
    }
    @PutMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userServiceImpl.updateUser(user);
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
        return "redirect:/user/user-list";
    }
    @GetMapping("/deleteUser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteUser(@RequestParam("UserId") Long id){
        userServiceImpl.deleteUser(id);
        return "redirect:/user/user-list";
    }
}
