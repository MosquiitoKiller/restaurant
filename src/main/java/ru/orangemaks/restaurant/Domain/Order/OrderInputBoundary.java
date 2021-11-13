package ru.orangemaks.restaurant.Domain.Order;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public interface OrderInputBoundary {
    OrderResponseModel getAll();
}
