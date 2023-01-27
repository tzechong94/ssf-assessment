package com.example.assessment.model;

import org.springframework.beans.factory.annotation.Value;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Delivery {
    
    @NotBlank(message = "Name is mandatory.")
    @Size(min=3, message = "Name must have minimum 3 characters.")
    private String name;

    // private String id;

    @NotBlank(message = "Delivery Address is mandatory.")
    private String deliveryAddress;

    @Size(min= 8, max=8, message="Phone number must be 8 digits")
    private String phoneNumber;

    @Value("${delivery.rush:false}")
    private boolean rush;

    private String comments;

    // public Delivery(String name, String deliveryAddress, String phoneNumber) {
    //     this.id=generateId(8);
    //     this.name= name;
    //     this.deliveryAddress=deliveryAddress;
    //     this.phoneNumber = phoneNumber;

    // }

    // private Integer totalCost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public String getId() {
    //     return id;
    // }

    // public void setId(String id) {
    //     this.id = id;
    // }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isRush() {
        return rush;
    }

    public void setRush(boolean rush) {
        this.rush = rush;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    // public Integer getTotalCost() {
    //     return totalCost;
    // }

    // public void setTotalCost(Integer totalCost) {
    //     this.totalCost = totalCost;
    // }

}
