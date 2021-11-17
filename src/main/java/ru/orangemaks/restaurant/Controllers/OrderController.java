package ru.orangemaks.restaurant.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.orangemaks.restaurant.Domain.Order.OrderInputBoundary;
import ru.orangemaks.restaurant.Domain.Order.OrderResponseModel;
import ru.orangemaks.restaurant.Models.ProductCategories;

@RestController
public class OrderController {

    private final OrderInputBoundary orderInputBoundary;

    public OrderController(OrderInputBoundary orderInputBoundary) {
        this.orderInputBoundary = orderInputBoundary;
    }

    @GetMapping("/getProductsCategories")
    public String[] getAllProductCategories(){
        String[] categories = new String[ProductCategories.values().length];
        for (int i = 0; i < ProductCategories.values().length; i++) {
            categories[i] = ProductCategories.values()[i].getCategory();
        }
        return categories;
    }

    @GetMapping("/get_menu")
    public OrderResponseModel getAllProducts(){
        return orderInputBoundary.getAll();
    }
}
