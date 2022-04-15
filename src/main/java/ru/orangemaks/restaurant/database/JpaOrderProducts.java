package ru.orangemaks.restaurant.database;

import ru.orangemaks.restaurant.domain.order.OrderProductDataAccess;
import ru.orangemaks.restaurant.entities.OrderProducts;
import ru.orangemaks.restaurant.repositories.OrdersProductsRepository;

/**
 * Class data access to OrderProducts
 */
public class JpaOrderProducts implements OrderProductDataAccess {
    /**
     * data access
     */
    private final OrdersProductsRepository ordersProductsRepository;

    public JpaOrderProducts(OrdersProductsRepository ordersProductsRepository) {
        this.ordersProductsRepository = ordersProductsRepository;
    }

    /**
     * save new orderProducts
     * @param orderProducts orderProducts for save
     */
    @Override
    public void save(OrderProducts orderProducts) {
        ordersProductsRepository.save(orderProducts);
    }
}
