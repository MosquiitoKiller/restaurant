package ru.orangemaks.restaurant.Domain.Admin.Products;

import ru.orangemaks.restaurant.Entities.Product;

import java.util.List;

public interface Admin_ProductDataAccess {
    List<Product> getAll();
    List<Product> filter(Long id,String name,String category);
    Product findById(Long id);
    void save(Product product);
    Product deleteById(Long id);
}
