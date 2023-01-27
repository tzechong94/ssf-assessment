package com.example.assessment.model;

import java.io.Serializable;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Delivery implements Serializable{
    
    private String pizzaName;
    private String size;
    private Integer quantity;
    private Float totalCost;

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @NotBlank(message = "Name is mandatory.")
    @Size(min=3, message = "Name must have minimum 3 characters.")
    private String name;

    private String id;

    @NotBlank(message = "Delivery Address is mandatory.")
    private String deliveryAddress;

    @Size(min= 8, max=8, message="Phone number must be 8 digits")
    private String phoneNumber;

    @Value("${delivery.rush:false}")
    private boolean rush;

    private String comments;

    private synchronized String generateId(int numOfChar) {
        Random r = new Random();
        StringBuilder strBuilder = new StringBuilder();
        while(strBuilder.length() < numOfChar) {
            strBuilder.append(Integer.toHexString(r.nextInt()));
        }
        return strBuilder.toString().substring(0,numOfChar);
    }

    public Delivery(String pizzaName, String size, Integer quantity){
        this.pizzaName = pizzaName;
        this.size = size;
        this.quantity = quantity;
        this.id=generateId(8);
    }

    public Delivery(){
        this.id=generateId(8);
    }



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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }

}
