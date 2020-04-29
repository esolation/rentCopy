package com.epamLastTask.controllers;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.Request;
import com.epamLastTask.entities.User;
import com.epamLastTask.entities.enums.RequestStatus;
import com.epamLastTask.repositories.OrderRepo;
import com.epamLastTask.repositories.UserRepo;
import com.epamLastTask.service.OrderService;
import com.epamLastTask.service.RequestService;
import com.epamLastTask.service.UserService;
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

import java.util.List;

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
        model.addAttribute("requests", requestService.findAllAwaitingPaymentAndActiveByUserId(user.getId()));


        return "cp";
    }

    @PostMapping("remove/{order}")
    public String removeOrder(@PathVariable Order order,@AuthenticationPrincipal User user){
        orderService.removeOrder(user,order);
        return "redirect:/cp";
    }


}
