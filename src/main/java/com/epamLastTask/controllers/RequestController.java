package com.epamLastTask.controllers;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.Request;
import com.epamLastTask.entities.User;
import com.epamLastTask.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cp/request")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @PostMapping("{order}")
    public String createRequest(@AuthenticationPrincipal User user,
                                @PathVariable Order order,
                                @RequestParam(name="totalCost") String totalCost,
                                @RequestParam(name="orderDays") String orderDays){

        requestService.createRequest(user.getId(),order,orderDays);
        return "redirect:/cp";
    }

    @PostMapping("complete/{request}")
    public String completeRequest(@PathVariable Request request){
            requestService.completeRequest(request);
        return "redirect:/cp";
    }
}
