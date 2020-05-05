package com.epamLastTask.repositories;

import com.epamLastTask.entities.Order;
import com.epamLastTask.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findAllOrderByUser(User user);
    Order findOrderById(Long id);
    Page<Order> findAllByAvaliable(boolean bool, Pageable pageable);
    List<Order> findAllByAvaliable(boolean bool);
}
