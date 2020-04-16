package com.epamLastTask.controllers;

import com.epamLastTask.entities.Order;
import com.epamLastTask.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class CreateOrderController {
    @Autowired
    private OrderService orderService;

    private String uploadPath;
    @PostMapping("/createOrder")
    public String addOrder(
            @RequestParam("file") MultipartFile[] file,
            Order order
    ) throws IOException  {

        orderService.createOrder(file, order);
        return "redirect:hello";
    }
    @GetMapping("/createOrder")
    public String addImg(){

        return "createOrder";
    }
}
