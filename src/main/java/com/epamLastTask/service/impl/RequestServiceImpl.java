package com.epamLastTask.service.impl;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.Request;
import com.epamLastTask.entities.enums.RequestStatus;
import com.epamLastTask.repositories.RequestRepo;
import com.epamLastTask.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        request.setRequestStatus(RequestStatus.OPEN);
        requestRepo.save(request);
    }

    @Override
    public void removeRequest(Order order) {

    }
    @Transactional
    @Override
    public void applyRequest(Request request, String message, String money) {
        if(message==null || money ==null){
            request.setRequestStatus(RequestStatus.COMPLETE);
            request.getOrder().setActive(true);
            request.getOrder().setUser(null);
        }
        else {
            request.setRequestStatus(RequestStatus.AWAITING_PAYMENT);
            request.setMessage(message);
            request.setRepairCost(Double.parseDouble(money));
        }
        requestRepo.save(request);
    }

    @Override
    public List<Request> findAll() {
        return requestRepo.findAll();
    }

    @Override
    public List<Request> findAllByRequestStatus(RequestStatus requestStatus) {
        return requestRepo.findAllByRequestStatus(requestStatus);
    }
}
