package com.epamLastTask.controllers;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.User;
import com.epamLastTask.service.OrderService;
import com.epamLastTask.service.RequestService;
import com.epamLastTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cp")
public class CpController {

@Autowired
private UserService userService;
@Autowired
private OrderService orderService;
@Autowired
private RequestService requestService;
    @GetMapping()
    public String getClientOrders(@AuthenticationPrincipal User user,
                                  Model model){
        model.addAttribute("user",(userService.findUserById(user.getId())));
        model.addAttribute("requests", requestService.findAllAwaitingPaymentAndActiveAndProcessingAndRejectedByUserId(user.getId()));
        model.addAttribute("processed",true);

        return "cp";
    }

    @PostMapping("remove/{order}")
    public String removeOrder(@PathVariable Order order,@AuthenticationPrincipal User user){
        orderService.removeOrder(user,order);
        return "redirect:/cp";
    }


}
