package com.epamLastTask.controllers;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.User;
import com.epamLastTask.repositories.OrderRepo;
import com.epamLastTask.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cp")
public class CpController {
@Autowired
private OrderRepo orderRepo;
@Autowired
private UserRepo userRepo;
    @GetMapping()
    @Transactional(propagation= Propagation.REQUIRED, readOnly = true)
    public String getClientOrders(@AuthenticationPrincipal User user, Model model){


        model.addAttribute("user",userRepo.findByUsername(user.getUsername()));
        return "cp";
    }

    @PostMapping("delete")
    public String deleteOrder(@AuthenticationPrincipal User user){

        Order order = orderRepo.findOrderByUser(user);
        order.deleteUser();
        order.setActive(true);
        orderRepo.save(order);
        return "redirect:/cp";
    }
}
