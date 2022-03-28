package ru.orangemaks.restaurant.domain.order;

import org.springframework.stereotype.Component;

@Component
public interface OrderInputBoundary {
    MenuResponseModel getAll();
    BasketResponseModel getProductsById(BasketRequestModel basketRequestModel);
    boolean formOrder(OrderRequestModel orderRequestModel);
}
