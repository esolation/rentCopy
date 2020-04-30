package com.epamLastTask.entities;

import com.epamLastTask.entities.enums.RequestStatus;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Calendar dateOfCreating;
    @Temporal(TemporalType.DATE)
    private Calendar rentalDate;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;
    private Double repairCost;
    private Long userID;
    private String userName;
    private String message;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;


    public Double getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(Double repairCost) {
        this.repairCost = repairCost;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Calendar getDateOfCreating() {
        return dateOfCreating;
    }

    public void setDateOfCreating(Calendar dateOfCreating) {
        this.dateOfCreating = dateOfCreating;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Calendar getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Calendar rentalDate) {
        this.rentalDate = rentalDate;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
