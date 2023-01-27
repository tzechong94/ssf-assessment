package com.example.assessment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.assessment.model.Delivery;
import com.example.assessment.model.Order;

import jakarta.validation.Valid;

@Controller
public class PizzaController {
    
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
        // model.addAttribute("order", order);
        model.addAttribute("delivery", new Delivery());
        return "delivery";

    }

    @PostMapping(path="/pizza/order")
    public String postOrder(@Valid Delivery delivery, BindingResult bindingResult,
    Model model) {
        if (bindingResult.hasErrors()){
            return "delivery";
        } 
        return "confirmation";
    }
}
