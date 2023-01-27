package com.example.assessment.model;

import java.io.Serializable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Order implements Serializable {
    
    @NotNull(message = "Please select a pizza.")
    private String pizzaName;

    @NotNull(message = "Please select a size.")
    private String pizzaSize;

    @NotNull(message = "Please enter a quantity from 1 to 10.")
    @Min(value = 1, message="Quantity cannot be less than 1.")
    @Max(value = 10, message="Quantity cannot be more than 10.")
    private Integer pizzaQuantity;

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaType) {
        this.pizzaName = pizzaType;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public Integer getPizzaQuantity() {
        return pizzaQuantity;
    }

    public void setPizzaQuantity(Integer pizzaQuantity) {
        this.pizzaQuantity = pizzaQuantity;
    }

    // public Order(String pizzaName, String pizzaSize, Integer pizzaQuantity) {
    //     this.pizzaSize = pizzaSize;
    //     this.pizzaName = pizzaName;
    //     this.pizzaQuantity = pizzaQuantity;
    // }

    

}
