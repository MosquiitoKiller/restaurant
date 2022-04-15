package ru.orangemaks.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.orangemaks.restaurant.entities.Product;

/**
 * data access for the Product object
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    /**
     * find product by name
     * @param name name
     * @return product by name
     */
    Product findByName(String name);
}
