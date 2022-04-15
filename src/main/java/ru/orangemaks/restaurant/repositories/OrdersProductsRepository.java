package ru.orangemaks.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.orangemaks.restaurant.entities.OrderProducts;

/**
 * data access for the OrderProducts object
 */
@Repository
public interface OrdersProductsRepository extends JpaRepository<OrderProducts,Long> {
}
