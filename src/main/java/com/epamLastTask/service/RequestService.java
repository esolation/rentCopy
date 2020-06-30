package com.epamLastTask.service;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.Request;

import com.epamLastTask.entities.User;
import com.epamLastTask.entities.enums.RequestStatus;

import java.util.Date;
import java.util.List;

public interface RequestService {
    void createRequest(User user, Order order, Date orderBeginning, Date orderEnding);
    void removeRequest(Order order);
    void applyRequest(Request request, String message, String money, User user);
    void completeRequest(Request request, User user);
    List<Request> findAll();
    List<Request> findAllByRequestStatus(RequestStatus requestStatus);
    Request findByRequestStatusAndUserId(RequestStatus requestStatus,Long id);
    List<Request> findAllByUserId(Long id);
    List<Request> findActiveRequest(Long id);
    List<Request> findAwaitingPaymentRequest(Long id);
    List<Request> findCompleteRequestByUserId(Long id);
    List<Request> findAllAwaitingPaymentAndActiveAndProcessingAndRejectedByUserId(Long id);

    void activeRequest(Request request, User user);

    void rejectRequest(Request request, String message, User user);

    void deleteRejected(Request request);
    double getRentCost(double l, double cost);
    void payForRequest(Request request, User user);
}
