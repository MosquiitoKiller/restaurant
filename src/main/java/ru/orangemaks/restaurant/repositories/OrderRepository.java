package ru.orangemaks.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.orangemaks.restaurant.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
