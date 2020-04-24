package com.epamLastTask.service.impl;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.Request;
import com.epamLastTask.entities.enums.OrderStatus;
import com.epamLastTask.repositories.RequestRepo;
import com.epamLastTask.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepo requestRepo;


    @Transactional
    @Override
    public void createRequest(Order order) {

        order.setActive(false);
        Request request = new Request();
        request.setOrder(order);
        request.setDateOfCreating(new Date());
        request.setRentalDate(new Date());
        request.setMessage(null);
        request.setRepairCost(null);
        request.setOrderStatus(OrderStatus.OPEN);
        requestRepo.save(request);
    }

    @Override
    public void removeRequest(Order order) {

    }

    @Override
    public void applyRequest(Order order) {

    }

    @Override
    public List<Request> findAll() {
        return requestRepo.findAll();
    }
}