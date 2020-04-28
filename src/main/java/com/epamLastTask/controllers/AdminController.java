package com.epamLastTask.controllers;

import com.epamLastTask.entities.Request;
import com.epamLastTask.entities.enums.RequestStatus;
import com.epamLastTask.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @Autowired
    RequestService requestService;
    @GetMapping("active")
    public String adminPage(Model model){

        model.addAttribute("requests",requestService.findAllByRequestStatus(RequestStatus.OPEN));

        return "admin_panel";
    }
    @GetMapping("complete")
    public String adminPageComplete(Model model){

        model.addAttribute("requests",requestService.findAllByRequestStatus(RequestStatus.COMPLETE));

        return "admin-panel_complete";
    }
    @GetMapping("awaitingPayments")
    public String adminPageAwaitingPayment(Model model){

        model.addAttribute("requests",requestService.findAllByRequestStatus(RequestStatus.AWAITING_PAYMENT));

        return "admin-panel_awaitingPayment";
    }



    @GetMapping("complete/{requestId}")
    public String completeRequest(){

        return "complete_request";
    }

    @PostMapping("complete/{requestId}")
    public String completeRequest(@PathVariable Request requestId,
                                  @RequestParam(required = false) String message,
                                  @RequestParam(required = false) String money){
        requestService.applyRequest(requestId,message,money);
        return "redirect:/admin/active";
    }

}
