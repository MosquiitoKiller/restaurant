package ru.orangemaks.restaurant.database;

import ru.orangemaks.restaurant.domain.order.OrderDataAccess;
import ru.orangemaks.restaurant.entities.Order;
import ru.orangemaks.restaurant.repositories.OrderRepository;

/**
 * Class data access to Order
 */
public class JpaOrder implements OrderDataAccess {
    /**
     * data access
     */
    private final OrderRepository orderRepository;

    public JpaOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * save new order
     * @param order order for save
     */
    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
