package com.epamLastTask.repositories;

import com.epamLastTask.entities.Request;
import com.epamLastTask.entities.enums.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestRepo extends JpaRepository<Request,Long> {
    List<Request> findAllByRequestStatus(RequestStatus requestStatus);
    Request findByRequestStatusAndOrder_User_Id(RequestStatus requestStatus,Long id);
    List<Request> findAllByUserID(Long id);


}
