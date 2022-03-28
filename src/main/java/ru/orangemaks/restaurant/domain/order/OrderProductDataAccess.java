package ru.orangemaks.restaurant.domain.order;

import ru.orangemaks.restaurant.entities.OrderProducts;

public interface OrderProductDataAccess {
    void save(OrderProducts orderProducts);
}
