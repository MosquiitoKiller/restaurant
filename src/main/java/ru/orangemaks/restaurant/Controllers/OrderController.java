package ru.orangemaks.restaurant.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.orangemaks.restaurant.Domain.Order.OrderInputBoundary;
import ru.orangemaks.restaurant.Domain.Order.OrderResponseModel;

@RestController
public class OrderController {

    private final OrderInputBoundary orderInputBoundary;

    public OrderController(OrderInputBoundary orderInputBoundary) {
        this.orderInputBoundary = orderInputBoundary;
    }

    @GetMapping("/get_menu")
    public OrderResponseModel getAllProducts(){
        return orderInputBoundary.getAll();
    }
}
