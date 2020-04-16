package com.epamLastTask.controllers;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.User;
import com.epamLastTask.repositories.OrderRepo;
import com.epamLastTask.repositories.UserRepo;
import com.epamLastTask.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cp")
public class CpController {

@Autowired
private UserRepo userRepo;
@Autowired
private OrderService orderService;
    @GetMapping()
    public String getClientOrders(@AuthenticationPrincipal User user,
                                  Model model){
        model.addAttribute("user",userRepo.findByUsername(user.getUsername()));
        return "cp";
    }

    @PostMapping("remove/{order}")
    public String removeOrder(@PathVariable Order order){
        orderService.removeOrder(order);
        return "redirect:/cp";
    }

    @PostMapping("accept/{order}")
    public String acceptOrder(@PathVariable Order order){


        return "redirect:/cp";
    }
}
