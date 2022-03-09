package ru.orangemaks.restaurant.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.orangemaks.restaurant.Entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
