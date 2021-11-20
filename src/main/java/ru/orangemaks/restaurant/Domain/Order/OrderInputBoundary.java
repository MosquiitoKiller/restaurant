package ru.orangemaks.restaurant.Domain.Order;

import org.springframework.stereotype.Component;

@Component
public interface OrderInputBoundary {
    OrderResponseModel getAll();
    BasketResponseModel getProductsById(BasketRequestModel basketRequestModel);
}
