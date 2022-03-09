package ru.orangemaks.restaurant.Domain.Order;

import ru.orangemaks.restaurant.Entities.OrderProducts;

public interface OrderProductDataAccess {
    void save(OrderProducts orderProducts);
}
