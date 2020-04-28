package com.epamLastTask.service;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.Request;

import com.epamLastTask.entities.enums.RequestStatus;

import java.util.List;

public interface RequestService {
    void createRequest(Long userId, Order order);
    void removeRequest(Order order);
    void applyRequest(Request request, String message, String money);
    void completeRequest(Request request);
    List<Request> findAll();
    List<Request> findAllByRequestStatus(RequestStatus requestStatus);
    Request findByRequestStatusAndUserId(RequestStatus requestStatus,Long id);
    List<Request> findAllByUserId(Long id);
    List<Request> findActiveRequest(Long id);
    List<Request> findAwaitingPaymentRequest(Long id);
    List<Request> findCompleteRequest(Long id);
}
