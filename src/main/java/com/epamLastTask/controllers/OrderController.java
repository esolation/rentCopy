package com.epamLastTask.controllers;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.User;
import com.epamLastTask.repositories.OrderRepo;
import com.epamLastTask.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
@Autowired
private UserRepo userRepo;
@Autowired
private OrderRepo orderRepo;
    @GetMapping("{order}")
    public String order(@PathVariable Order order,
                        Model model){

        model.addAttribute("order",order);
        return "order";
    }

    @PostMapping("{order}")
    public String addOrder(@PathVariable Order order,
                           @AuthenticationPrincipal User user,
                           Model model){

        order.setActive(false);
        order.setUser(user);
        orderRepo.save(order);


        return "redirect:/hello";
    }
}
