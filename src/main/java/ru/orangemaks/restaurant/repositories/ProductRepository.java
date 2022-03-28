package ru.orangemaks.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.orangemaks.restaurant.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByName(String name);
}
