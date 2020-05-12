package com.epamLastTask.service.impl;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.Request;
import com.epamLastTask.entities.User;
import com.epamLastTask.entities.enums.RequestStatus;
import com.epamLastTask.repositories.RequestRepo;
import com.epamLastTask.repositories.UserRepo;
import com.epamLastTask.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepo requestRepo;
    @Autowired
    private UserRepo userRepo;


    @Transactional
    @Override
    public void createRequest(User user, Order order, String orderDays) {

        order.getUser().clear();
        order.getUser().add(userRepo.findUserById(user.getId()));
        order.setAvaliable(false);
        Request request = new Request();
        request.setOrder(order);
        request.setUserID(user.getId());
        request.setUserName(user.getUsername());
        Calendar rentalDay = Calendar.getInstance();
        rentalDay.add(Calendar.DAY_OF_MONTH, Integer.parseInt(orderDays));
        request.setDateOfCreating(Calendar.getInstance());
        request.setRentalDate(rentalDay);
        request.setMessage(null);
        request.setRepairCost(null);
        request.setRequestStatus(RequestStatus.AWAITING_PROCESSING);
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
            request.getOrder().setAvaliable(true);
            request.getOrder().getUser().clear();
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
        request.getOrder().setAvaliable(true);
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
    public List<Request> findCompleteRequestByUserId(Long id) {
        List<Request> total = new ArrayList<>();
       total.addAll(requestRepo.findAllByRequestStatusAndUserID(RequestStatus.COMPLETE,id));
       total.addAll(requestRepo.findAllByRequestStatusAndUserID(RequestStatus.REJECTED_HISTORY,id));
       return total;
    }

    @Transactional
    @Override
    public List<Request> findAllAwaitingPaymentAndActiveAndProcessingAndRejectedByUserId(Long id) {
        List<Request> total = new ArrayList<>();
        total.addAll(requestRepo.findAllByRequestStatusAndUserID(RequestStatus.OPEN,id));
        total.addAll(requestRepo.findAllByRequestStatusAndUserID(RequestStatus.AWAITING_PAYMENT,id));
        total.addAll(requestRepo.findAllByRequestStatusAndUserID(RequestStatus.AWAITING_PROCESSING,id));
        total.addAll(requestRepo.findAllByRequestStatusAndUserID(RequestStatus.REJECTED,id));
        return total;
    }

    @Override
    public void activeRequest(Request request) {
        request.setRequestStatus(RequestStatus.OPEN);
        requestRepo.save(request);
    }

    @Transactional
    @Override
    public void rejectRequest(Request request, String message) {
        request.setRequestStatus(RequestStatus.REJECTED);
        request.getOrder().setAvaliable(true);
        request.getOrder().setUser(null);
        request.setMessage(message);
        requestRepo.save(request);
    }

    @Override
    public void deleteRejected(Request request) {
        request.setRequestStatus(RequestStatus.REJECTED_HISTORY);
        requestRepo.save(request);
    }


}
