package com.epamLastTask.controllers;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.User;
import com.epamLastTask.repositories.OrderRepo;
import com.epamLastTask.repositories.UserRepo;
import com.epamLastTask.service.OrderService;
import com.epamLastTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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
private OrderService orderService;
@Autowired
private UserService userService;
    @GetMapping("{order}")
    public String order(@PathVariable Order order,@AuthenticationPrincipal User user,
                        Model model){


        model.addAttribute("userHaveOrder",orderService.currentUserHaveThisOrder(user,order));
        model.addAttribute("order",order);
        return "order";
    }

    @PostMapping("{order}")
    public String addOrderToCard(@PathVariable Order order,
                           @AuthenticationPrincipal User user,
                           Model model){

       orderService.addOrderToCard(order,user);
        return "redirect:/hello";
    }
}
