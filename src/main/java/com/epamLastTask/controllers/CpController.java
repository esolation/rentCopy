package com.epamLastTask.controllers;

import com.epamLastTask.domains.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cp")
public class CpController {

    @GetMapping()
    public String getClientOrders(@AuthenticationPrincipal User user,
                                  Model model){

        model.addAttribute("user",user);
        return "cp";
    }
}
