package com.epamLastTask.service.impl;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.Request;
import com.epamLastTask.entities.enums.RequestStatus;
import com.epamLastTask.repositories.RequestRepo;
import com.epamLastTask.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepo requestRepo;


    @Transactional
    @Override
    public void createRequest(Long userId, Order order) {

        order.setActive(false);
        Request request = new Request();
        request.setOrder(order);
        request.setUserID(userId);

        request.setDateOfCreating(Calendar.getInstance());
        request.setRentalDate(Calendar.getInstance());
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
        if((message==null || money ==null)|| (message.equals("") || money.equals(""))){
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
    public void completeRequest(Request request) {
        request.setRequestStatus(RequestStatus.COMPLETE);
        request.getOrder().setActive(true);
        request.getOrder().setUser(null);
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

    @Override
    public Request findByRequestStatusAndUserId(RequestStatus requestStatus, Long id) {
        return requestRepo.findByRequestStatusAndOrder_User_Id(requestStatus,id);
    }

    @Override
    public List<Request> findAllByUserId(Long id) {
        return requestRepo.findAllByUserID(id);
    }

    @Override
    public List<Request> findActiveRequest(Long id) {
        List<Request> allRequests = findAllByUserId(id);
        return allRequests.stream().filter(r-> r.getRequestStatus()==RequestStatus.OPEN).collect(Collectors.toList());
    }

    @Override
    public List<Request> findAwaitingPaymentRequest(Long id) {
        List<Request> allRequests = findAllByUserId(id);
        return allRequests.stream().filter(r-> r.getRequestStatus()==RequestStatus.AWAITING_PAYMENT).collect(Collectors.toList());
    }

    @Override
    public List<Request> findCompleteRequest(Long id) {
        List<Request> allRequests = findAllByUserId(id);
        return allRequests.stream().filter(r-> r.getRequestStatus()==RequestStatus.COMPLETE).collect(Collectors.toList());
    }


}
