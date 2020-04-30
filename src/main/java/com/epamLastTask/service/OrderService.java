package com.epamLastTask.service;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface OrderService {
    void removeOrder(User user, Order order);
    void createOrder(MultipartFile[] file, Order order) throws IOException;
    void addOrderToCard(Order order, User user);
    boolean currentUserHaveThisOrder(User user, Order order);
}
