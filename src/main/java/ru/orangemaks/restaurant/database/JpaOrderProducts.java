package ru.orangemaks.restaurant.database;

import ru.orangemaks.restaurant.domain.order.OrderProductDataAccess;
import ru.orangemaks.restaurant.entities.OrderProducts;
import ru.orangemaks.restaurant.repositories.OrdersProductsRepository;

public class JpaOrderProducts implements OrderProductDataAccess {
    private final OrdersProductsRepository ordersProductsRepository;

    public JpaOrderProducts(OrdersProductsRepository ordersProductsRepository) {
        this.ordersProductsRepository = ordersProductsRepository;
    }

    @Override
    public void save(OrderProducts orderProducts) {
        ordersProductsRepository.save(orderProducts);
    }
}
