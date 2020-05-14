package com.epamLastTask.controllers;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.Request;
import com.epamLastTask.entities.User;
import com.epamLastTask.service.RequestService;
import com.epamLastTask.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/cp/request")
public class RequestController {
    @Autowired
    private RequestService requestService;
    @Autowired
    UserService userService;
    @Autowired
    private Logger logger;

    @PostMapping("{order}")
    public String createRequest(@AuthenticationPrincipal User user,
                                @PathVariable Order order,
                                @RequestParam(name="dateOfBeginning") @DateTimeFormat(pattern = "yyyy-MM-dd")Date dayOfCreating,
                                @RequestParam(name="dateOfEnding") @DateTimeFormat(pattern = "yyyy-MM-dd")Date dayOfEnding,
                                Model model){
        requestService.createRequest(user,order,dayOfCreating,dayOfEnding);
        logger.info(user.getUsername() + " successful order " + order.getCarModel());
        return "redirect:/order/myOrders";
    }

    @PostMapping("complete/{request}")
    public String completeRequest(@PathVariable Request request){
            requestService.completeRequest(request);
        return "redirect:/cp";
    }
    @PostMapping("deleteRejected/{request}")
    public String deleteRejectedRequest(@PathVariable Request request){
        requestService.deleteRejected(request);
        return "redirect:/order/myOrders";
    }
}
