package ru.orangemaks.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
    @GetMapping("/admin/users/{userId}")
    public String showConcreteUser(@PathVariable Long userId){
        return "Admin/concreteUser";
    }

    @GetMapping("/admin/products/{productId}")
    public String showConcreteProduct(@PathVariable Long productId){
        return "Admin/concreteProduct";
    }
}
