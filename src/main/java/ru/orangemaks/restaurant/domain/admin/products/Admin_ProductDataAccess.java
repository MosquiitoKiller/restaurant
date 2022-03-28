package ru.orangemaks.restaurant.domain.admin.products;

import ru.orangemaks.restaurant.entities.Product;

import java.util.List;

public interface Admin_ProductDataAccess {
    List<Product> getAll();
    List<Product> filter(Long id,String name,String category);
    Product findById(Long id);
    void save(Product product);
    Product deleteById(Long id);
}
