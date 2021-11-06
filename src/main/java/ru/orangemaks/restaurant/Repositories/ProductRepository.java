package ru.orangemaks.restaurant.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.orangemaks.restaurant.Entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByName(String name);
}
