package com.epamLastTask.controllers;

import com.epamLastTask.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @Autowired
    RequestService requestService;
    @GetMapping
    public String adminPage(Model model){

        model.addAttribute("requests",requestService.findAll());

        return "admin_panel";
    }

}
