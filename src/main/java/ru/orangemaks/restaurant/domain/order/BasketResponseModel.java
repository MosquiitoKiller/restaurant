package ru.orangemaks.restaurant.domain.order;

import ru.orangemaks.restaurant.models.ProductDtoModel;

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
