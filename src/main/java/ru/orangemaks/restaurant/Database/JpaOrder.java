package ru.orangemaks.restaurant.Database;

import ru.orangemaks.restaurant.Domain.Order.OrderDataAccess;
import ru.orangemaks.restaurant.Entities.Order;
import ru.orangemaks.restaurant.Repositories.OrderRepository;

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
