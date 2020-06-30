package com.epamLastTask.controllers;

import com.epamLastTask.entities.User;
import com.epamLastTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
    public RedirectView register(@Valid User user , BindingResult bindingResult,RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = ControllerUtil.getErrorMessage(bindingResult);
            redirectAttributes.mergeAttributes(errorMap);
            redirectAttributes.addFlashAttribute("user", user);
            return new RedirectView("registration");
        }
        else {
            if(userService.saveUser(user) == 1){
                redirectAttributes.addAttribute("reg", "succes");
                return new RedirectView("login");
            }
            else if(userService.saveUser(user) == 0){
                redirectAttributes.addFlashAttribute("message","Пользователь с таким именем или email уже существует!");
                return new RedirectView("registration");
            }
            else {
                redirectAttributes.addFlashAttribute("passCheckError","Введен неверный номер пасспорта");
                redirectAttributes.addFlashAttribute("user",user);
                return new RedirectView("registration");
            }
        }
    }
}
