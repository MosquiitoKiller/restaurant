package ru.orangemaks.restaurant.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.orangemaks.restaurant.Entities.OrderProducts;

@Repository
public interface OrdersProductsRepository extends JpaRepository<OrderProducts,Long> {
}
