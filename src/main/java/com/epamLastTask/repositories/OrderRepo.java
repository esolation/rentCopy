package com.epamLastTask.repositories;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
    Order findOrderByUser(User user);
    Order findOrderById(Long id);
}
