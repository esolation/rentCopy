package com.epamLastTask.controllers;

import com.epamLastTask.domains.Role;
import com.epamLastTask.domains.User;
import com.epamLastTask.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("registration")
    public String getRegisterPage(){
        return "registration";
    }
    @PostMapping("registration")
    public String register(User user, Model model){

        if(userRepo.findByUsername(user.getUsername()) ==null & userRepo.findUserByEmail(user.getEmail())==null  ){
            user.setRole(Collections.singleton(Role.USER));

            userRepo.save(user);
        }
        else{
            model.addAttribute("message","Пользователь с таким именем или email уже существует!");
            return "registration";
        }

        return "redirect:login";
    }
}
