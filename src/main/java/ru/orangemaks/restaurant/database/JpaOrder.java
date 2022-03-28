package ru.orangemaks.restaurant.database;

import ru.orangemaks.restaurant.domain.order.OrderDataAccess;
import ru.orangemaks.restaurant.entities.Order;
import ru.orangemaks.restaurant.repositories.OrderRepository;

public class JpaOrder implements OrderDataAccess {
    private final OrderRepository orderRepository;

    public JpaOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
