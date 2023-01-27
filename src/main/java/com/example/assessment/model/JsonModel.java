package com.example.assessment.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;


import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

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

    public static JsonModel create(String json) throws IOException {
        JsonModel m = new JsonModel(null, null, 0);
        try (InputStream is = new ByteArrayInputStream(json.getBytes())) {
            JsonReader r = Json.createReader(is);
            JsonObject o = r.readObject();
            m.setOrderId(o.getString("orderId"));
            m.setName(o.getString("name"));
            m.setAddress(o.getString("address"));
            m.setPhone(o.getString("phone"));
            m.setRush(o.getBoolean("rush"));
            m.setComments(o.getString("comments"));
            m.setPizzaName(o.getString("pizzaName"));
            m.setQuantity(o.getInt("quantity"));
            m.setTotalCost(o.getInt("totalCost"));
        }
        return m;
    }


    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                    .add("orderId", this.getOrderId())
                    .add("name", this.getName())
                    .add("address", this.getAddress())
                    .add("phone", this.getPhone())
                    .add("rush", this.isRush())
                    .add("comments", this.getComments())
                    .add("pizzaName", this.getPizzaName())
                    .add("quantity", this.getQuantity())
                    .add("totalCost", this.getTotalCost())
                    .build();
    }
}
