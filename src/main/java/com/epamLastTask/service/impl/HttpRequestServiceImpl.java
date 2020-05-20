package com.epamLastTask.service.impl;

import com.epamLastTask.service.HttpRequestService;
import com.epamLastTask.utils.RequestURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class HttpRequestServiceImpl implements HttpRequestService {
    @Autowired
    private RequestURI requestURI;
    @Override
    public boolean checkUrlPath(HttpServletRequest request) {
        return (!request.getHeader("referer").equals("http://localhost:8080/login") && !request.getHeader("referer").equals("http://localhost:8080/registration"));
    }

    @Override
    public void saveUrlPath(HttpServletRequest request) {
        try {
            requestURI.setUri(new URI(request.getHeader("referer")).getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
