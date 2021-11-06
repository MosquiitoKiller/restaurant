package ru.orangemaks.restaurant.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.orangemaks.restaurant.Entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Product findByName(String name);
}
