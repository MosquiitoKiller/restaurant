package ru.orangemaks.restaurant.Domain.Order;

import ru.orangemaks.restaurant.Entities.Product;

import java.util.List;

public interface OrderDataAccess {
    List<Product> getAll();
    List<Product> filter(Long id,String name,String category);
}
