package com.epamLastTask.controllers;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.Request;
import com.epamLastTask.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cp/request")
public class RequestController {
    @Autowired
    private RequestService requestService;
    @PostMapping("{order}")
    public String createRequest(@PathVariable Order order){

        requestService.createRequest(order);
        return "redirect:/cp";
    }
}
