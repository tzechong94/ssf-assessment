package com.example.assessment.model;

import org.springframework.beans.factory.annotation.Value;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Delivery {
    
    
    @NotNull(message = "Name is mandatory.")
    @Size(min=3, message = "Name must have minimum 3 characters.")
    private String name;

    // private String id;

    @NotNull(message = "Address is mandatory.")
    private String address;

    @Min(value=8, message = "phone number must be at least 8 digits")
    private String phoneNumber;

    @Value("${delivery.rush:false}")
    private boolean rush;

    private String comments;

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


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    // public Integer getTotalCost() {
    //     return totalCost;
    // }

    // public void setTotalCost(Integer totalCost) {
    //     this.totalCost = totalCost;
    // }

}
