package com.epamLastTask.repositories;

import com.epamLastTask.domains.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
