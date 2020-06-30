package com.epamLastTask.controllers;

import com.epamLastTask.entities.Request;
import com.epamLastTask.entities.User;
import com.epamLastTask.entities.enums.RequestStatus;
import com.epamLastTask.service.RequestService;
import com.epamLastTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @Autowired
    private RequestService requestService;
    @Autowired
    private UserService userService;

    @GetMapping("users/{user}")
    public String getUser(@PathVariable User user, Model model){
        model.addAttribute("user",userService.findUserById(user.getId()));
        model.addAttribute("isAdmin", userService.isAdmin(user));
        return "showUser";
    }

    @GetMapping("active")
    public String adminPage(Model model){

        model.addAttribute("requests",requestService.findAllByRequestStatus(RequestStatus.OPEN));
        model.addAttribute("notification", requestService.findAllByRequestStatus(RequestStatus.AWAITING_PROCESSING).size());
        return "admin_panel";
    }
    @GetMapping("complete")
    public String adminPageComplete(Model model){

        model.addAttribute("requests",requestService.findAllByRequestStatus(RequestStatus.COMPLETE));
        model.addAttribute("notification", requestService.findAllByRequestStatus(RequestStatus.AWAITING_PROCESSING).size());
        return "admin-panel_complete";
    }
    @GetMapping("awaitingPayments")
    public String adminPageAwaitingPayment(Model model){
        model.addAttribute("requests",requestService.findAllByRequestStatus(RequestStatus.AWAITING_PAYMENT));
        model.addAttribute("notification", requestService.findAllByRequestStatus(RequestStatus.AWAITING_PROCESSING).size());
        return "admin-panel_awaitingPayment";
    }



    @GetMapping("complete/{requestId}")
    public String completeRequest(){

        return "complete_request";
    }

    @PostMapping("complete/{requestId}")
    public String completeRequest(@PathVariable Request requestId,
                                  @AuthenticationPrincipal User user,
                                  @RequestParam(required = false) String message,
                                  @RequestParam(required = false) String money){
        requestService.applyRequest(requestId,message,money, user);
        return "redirect:/admin/active";
    }
    @GetMapping("processing")
    public String processingRequests(Model model){
        model.addAttribute("requests", requestService.findAllByRequestStatus(RequestStatus.AWAITING_PROCESSING));
        model.addAttribute("notification", requestService.findAllByRequestStatus(RequestStatus.AWAITING_PROCESSING).size());
        return "admin-panel_processing";
    }
    @GetMapping("processing/active/{request}")
    public String activeRequest(@PathVariable Request request, @AuthenticationPrincipal User user){
        requestService.activeRequest(request, user);
        return "redirect:/admin/processing";
    }

    @PostMapping("processing/reject/{request}")
    public String rejectOrder(@PathVariable Request request,@RequestParam(name = "message") String message, @AuthenticationPrincipal User user){
        requestService.rejectRequest(request, message, user);
        return "redirect:/admin/processing";
    }



}
