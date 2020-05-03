package com.epamLastTask.controllers;


import com.epamLastTask.entities.User;
import com.epamLastTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Map;



@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getRegisterPage(){
        return "registration";
    }

    @PostMapping
    public String register(@Valid User user, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = ControllerUtil.getErrorMessage(bindingResult);
            model.mergeAttributes(errorMap);
            return "registration";
        }
        else {
            if(userService.saveUser(user)){
                return "redirect:login";
            }
            else{
                model.addAttribute("message","Пользователь с таким именем или email уже существует!");
                return "registration";
            }
        }




    }




}
