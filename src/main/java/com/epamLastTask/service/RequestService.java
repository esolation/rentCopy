package com.epamLastTask.service;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.Request;
import com.epamLastTask.entities.enums.RequestStatus;

import java.util.List;

public interface RequestService {
    void createRequest(Order order);
    void removeRequest(Order order);
    void applyRequest(Request request, String message, String money);
    List<Request> findAll();
    List<Request> findAllByRequestStatus(RequestStatus requestStatus);
}
