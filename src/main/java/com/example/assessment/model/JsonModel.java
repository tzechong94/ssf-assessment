package com.example.assessment.model;

import java.io.Serializable;

public class JsonModel implements Serializable{
    
    private String orderId;
    private String name;
    private String address;
    private String phone;
    private boolean rush;
    private String comments;
    private String pizzaName;
    private Integer quantity;
    private float totalCost;

    public JsonModel(Order order, Delivery delivery, float totalCost) {
        this.orderId = delivery.getId();
        this.name = delivery.getName();
        this.address = delivery.getDeliveryAddress();
        this.phone = delivery.getPhoneNumber();
        this.rush = delivery.isRush();
        this.comments = delivery.getComments();
        this.pizzaName = order.getPizzaName();
        this.quantity = order.getPizzaQuantity();
        this.totalCost = totalCost;
    }

    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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
    public String getPizzaName() {
        return pizzaName;
    }
    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public float getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    
}
