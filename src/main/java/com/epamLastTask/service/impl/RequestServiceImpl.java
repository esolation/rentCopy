package com.epamLastTask.service.impl;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.Request;
import com.epamLastTask.repositories.RequestRepo;
import com.epamLastTask.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepo requestRepo;

    @Override
    public void createRequest(Order order) {

        Request request = new Request();
        request.setPaid(false);
        request.setOrder(order);
        request.setDateOfCreating(new Date());
        requestRepo.save(request);
    }

    @Override
    public void removeRequest(Order order) {

    }

    @Override
    public void applyRequest(Order order) {

    }
}
