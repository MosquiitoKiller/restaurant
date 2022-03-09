package ru.orangemaks.restaurant.Domain.Order;

import ru.orangemaks.restaurant.Entities.Order;

public interface OrderDataAccess {
    void save(Order order);
}
