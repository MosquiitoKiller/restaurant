package ru.orangemaks.restaurant.domain.order;

import ru.orangemaks.restaurant.entities.Order;

public interface OrderDataAccess {
    void save(Order order);
}
