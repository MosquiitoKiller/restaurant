package ru.orangemaks.restaurant.Domain.Order;

import ru.orangemaks.restaurant.Models.ProductDtoModel;

import java.util.List;

public class BasketResponseModel {
    List<ProductDtoModel> products;

    public BasketResponseModel(List<ProductDtoModel> products) {
        this.products = products;
    }

    public List<ProductDtoModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDtoModel> products) {
        this.products = products;
    }
}
