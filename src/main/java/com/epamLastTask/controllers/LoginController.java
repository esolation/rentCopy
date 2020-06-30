package com.epamLastTask.controllers;

import com.epamLastTask.service.HttpRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private HttpRequestService httpRequestService;

    @GetMapping("/login")
    public String getLogin(HttpServletRequest request)  {
        if(httpRequestService.checkUrlPath(request))
        httpRequestService.saveUrlPath(request);
        return "/login";
    }
}
