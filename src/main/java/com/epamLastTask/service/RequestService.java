package com.epamLastTask.service;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.Request;

import java.util.List;

public interface RequestService {
    void createRequest(Order order);
    void removeRequest(Order order);
    void applyRequest(Order order);
    List<Request> findAll();
}
