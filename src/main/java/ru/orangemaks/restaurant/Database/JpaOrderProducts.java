package ru.orangemaks.restaurant.Database;

import ru.orangemaks.restaurant.Domain.Order.OrderProductDataAccess;
import ru.orangemaks.restaurant.Entities.OrderProducts;
import ru.orangemaks.restaurant.Repositories.OrdersProductsRepository;

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
