package com.example.assessment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.assessment.model.Delivery;
import com.example.assessment.model.JsonModel;
import com.example.assessment.model.Order;
import com.example.assessment.service.DeliveryService;

import jakarta.validation.Valid;

@Controller
public class PizzaController {
    
    @Autowired
    DeliveryService deliverySvc;

    private float totalCost = 0;
    private float pizzaCost = 0;

    private Order customerOrder = new Order();

    @GetMapping(path="/")
    public String getOrderForm(Model model) {
        model.addAttribute("order", new Order());
        return "form";
    }

    @PostMapping(path="/pizza")
    public String postOrder(@Valid Order order, BindingResult bindingResult,
    Model model) {
        if (bindingResult.hasErrors()){
            return "form";
        }
        // System.out.println("order:" + order.getPizzaName());
        // Delivery d = new Delivery();
        // d.setPizzaName(order.getPizzaName());
        // d.setQuantity(order.getPizzaQuantity());
        // d.setSize(order.getPizzaSize());
        // System.out.println("d:" + d.getPizzaName());
        customerOrder.setPizzaName(order.getPizzaName());
        customerOrder.setPizzaQuantity(order.getPizzaQuantity());
        customerOrder.setPizzaSize(order.getPizzaSize());
        model.addAttribute("delivery", new Delivery());
        return "delivery";
    }

    @PostMapping(path="/pizza/order")
    public String postOrder(@Valid Delivery delivery, BindingResult bindingResult,
    Model model) {
        
        if (bindingResult.hasErrors()){
            return "delivery";
        } 
        System.out.println(customerOrder.getPizzaName() + "pizzaname");
        totalCost = calculateTotalCost(customerOrder);
        pizzaCost = returnPizzaCost(customerOrder) * customerOrder.getPizzaQuantity();
        if (delivery.isRush()) {
            totalCost+=2;
        }
        System.out.println("total cost:" + totalCost);
        model.addAttribute("delivery", delivery);
        model.addAttribute("pizzaCost", pizzaCost);
        model.addAttribute("totalCost", totalCost);
        JsonModel j = new JsonModel(customerOrder, delivery, totalCost);
        deliverySvc.saveOrder(j);
        return "confirmation";
    }

    @GetMapping(path="/order/{orderId}")
    public ResponseEntity<String> getIndividualOrder(@PathVariable String orderId) throws Exception {
        JsonModel j = deliverySvc.findById(orderId);
        System.out.println(j);
        if (j == null){
            Map<String, String> bodymsg = new HashMap<>();
            bodymsg.put("message:",  "Order "+ orderId + " not found");
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(bodymsg.toString());
        }
        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(j.toJSON().toString());
    }

    private float returnPizzaCost(Order order) {
        if (order.getPizzaName().equals("bella") || 
        order.getPizzaName().equals("marinara") ||
        order.getPizzaName().equals("spianatacalabrese")) {
            pizzaCost = 30;
        }
        if (order.getPizzaName().equals("margherita")){
            pizzaCost = 22;
        }
        if (order.getPizzaName().equals("trioformaggio")){
            pizzaCost = 25;
        }
        return pizzaCost;
    }

    private float calculateTotalCost(Order order) {
        if (order.getPizzaName().equals("bella") || 
        order.getPizzaName().equals("marinara") ||
        order.getPizzaName().equals("spianatacalabrese")) {
            totalCost = 30;
            if (order.getPizzaSize().equals("md")) {
                totalCost *= 1.2;
            }
            if (order.getPizzaSize().equals("lg")){
                totalCost *= 1.5;
            }
        }  
        if (order.getPizzaName().equals("margherita")){
            totalCost = 22;
            if (order.getPizzaSize().equals("md")) {
                totalCost *= 1.2;
            }
            if (order.getPizzaSize().equals("lg")){
                totalCost *= 1.5;
            }

        }
        if (order.getPizzaName().equals("trioformaggio")){
            totalCost = 25;
            if (order.getPizzaSize().equals("md")) {
                totalCost *= 1.2;
            }
            if (order.getPizzaSize().equals("lg")){
                totalCost *= 1.5;
            }
        }

        return totalCost*order.getPizzaQuantity();

    }

}
