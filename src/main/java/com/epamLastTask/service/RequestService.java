package com.epamLastTask.service;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.Request;

public interface RequestService {
    void createRequest(Order order);
    void removeRequest(Order order);
    void applyRequest(Order order);
}
