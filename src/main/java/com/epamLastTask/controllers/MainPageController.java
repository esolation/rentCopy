package com.epamLastTask.controllers;

import com.epamLastTask.domains.User;
import com.epamLastTask.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {
    @Autowired
    private OrderRepo orderRepo;
    @GetMapping("/hello")
    public String main_page(@AuthenticationPrincipal User user,
            Model model){
        model.addAttribute("orders", orderRepo.findAll() );
        return "hello";
    }
}
