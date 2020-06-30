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

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/order")
public class OrderController {
@Autowired
private OrderService orderService;
@Autowired
private RequestService requestService;
@Autowired
private UserService userService;
    @GetMapping("{order}")
    public String order(@PathVariable Order order,@AuthenticationPrincipal User user,
                        Model model){
        if(user !=null) {
            model.addAttribute("userHaveOrder", orderService.currentUserHaveThisOrder(user, order));
            model.addAttribute("isAdmin", userService.isAdmin(user));
        }
        model.addAttribute("order", order);

        return "order";
    }

    @PostMapping("{order}")
    public String addOrderToCard(@PathVariable Order order,
                           @AuthenticationPrincipal User user,
                           HttpServletRequest request,
                           Model model){
        if(user!=null) {
            orderService.addOrderToCard(order, user);
            model.addAttribute("userHaveOrder", orderService.currentUserHaveThisOrder(user, order));
        }
        return "redirect:" + request.getRequestURI();
    }

    @GetMapping("/myOrders")
    public String getMyOrders(@AuthenticationPrincipal User user,
                              Model model){

        model.addAttribute("requests", requestService.findAllAwaitingPaymentAndActiveAndProcessingAndRejectedByUserId(user.getId()));
        return "my-orders";
    }
}
