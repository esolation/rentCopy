package com.epamLastTask.repositories;

import com.epamLastTask.entities.Request;
import com.epamLastTask.entities.enums.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepo extends JpaRepository<Request,Long> {
    List<Request> findAllByRequestStatus(RequestStatus requestStatus);
}
