package ru.orangemaks.restaurant.domain.order;

import ru.orangemaks.restaurant.entities.Product;

import java.util.List;

public interface MenuDataAccess {
    List<Product> getAll();
    List<Product> filter(Long id,String name,String category);
    Product findById(Long id);
}
