package ru.orangemaks.restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controller for give pages with PathVariable endpoints
 */
@Controller
public class PageController {
    /**
     * give page with concrete user
     * @param userId concrete user id
     * @return html-page
     */
    @GetMapping("/admin/users/{userId}")
    public String showConcreteUser(@PathVariable Long userId){
        return "Admin/concreteUser";
    }

    /**
     * give page with concrete product
     * @param productId concrete product id
     * @return html-page
     */
    @GetMapping("/admin/products/{productId}")
    public String showConcreteProduct(@PathVariable Long productId){
        return "Admin/concreteProduct";
    }
}
