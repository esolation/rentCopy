package com.epamLastTask.repositories;

import com.epamLastTask.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<Request,Long> {
}
