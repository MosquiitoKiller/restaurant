package ru.orangemaks.restaurant.Domain.Order;

import ru.orangemaks.restaurant.Models.ProductCategories;
import ru.orangemaks.restaurant.Models.ProductDtoModel;

import java.util.HashMap;
import java.util.List;

public class OrderResponseModel {
    HashMap<ProductCategories,List<ProductDtoModel>> products;
    ProductCategories[] categories;

    public OrderResponseModel(HashMap<ProductCategories, List<ProductDtoModel>> products, ProductCategories[] categories) {
        this.products = products;
        this.categories = categories;
    }

    public HashMap<ProductCategories, List<ProductDtoModel>> getProducts() {
        return products;
    }

    public void setProducts(HashMap<ProductCategories, List<ProductDtoModel>> products) {
        this.products = products;
    }

    public ProductCategories[] getCategories() {
        return categories;
    }

    public void setCategories(ProductCategories[] categories) {
        this.categories = categories;
    }
}
