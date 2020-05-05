package com.epamLastTask.controllers;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.Request;
import com.epamLastTask.entities.User;
import com.epamLastTask.entities.enums.RequestStatus;
import com.epamLastTask.repositories.OrderRepo;
import com.epamLastTask.service.RequestService;
import com.epamLastTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MainPageController {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserService userService;

    @Autowired
    private RequestService requestService;


    @GetMapping("/hello")
    public String main_page(@AuthenticationPrincipal User user,
                            Model model, @PageableDefault(sort = {"id"},direction = Sort.Direction.DESC, value = 6) Pageable pageable){
        User usr = userService.findUserById(user.getId());
        List<Order> userOrders = orderRepo.findAllOrderByUser(usr);
        List<Order> ord =  orderRepo.findAllByAvaliable(true);
        model.addAttribute("page", orderRepo.findAllByAvaliable(true,pageable));
        model.addAttribute("url","/hello");
        model.addAttribute("isAdmin", userService.isAdmin(user));
        model.addAttribute("userOrders", userOrders);
        return "hello";
    }
    @GetMapping("/history")
    public String getHistory(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("requests", requestService.findCompleteRequestByUserId(user.getId()));
        return "history";
    }

}
