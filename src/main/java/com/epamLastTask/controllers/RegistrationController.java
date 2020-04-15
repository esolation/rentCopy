package com.epamLastTask.controllers;

import com.epamLastTask.entities.enums.Role;
import com.epamLastTask.entities.User;
import com.epamLastTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("registration")
    public String getRegisterPage(){
        return "registration";
    }
    @PostMapping("registration")
    public String register(User user, Model model){

        if(userService.userIsAvailable(user) ){
            user.setRole(Collections.singleton(Role.USER));
            userService.save(user);
        }
        else{
            model.addAttribute("message","Пользователь с таким именем или email уже существует!");
            return "registration";
        }
        return "redirect:login";
    }
}
