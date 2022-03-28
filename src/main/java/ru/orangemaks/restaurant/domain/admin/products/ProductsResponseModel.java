package ru.orangemaks.restaurant.domain.admin.products;

import ru.orangemaks.restaurant.models.ProductDtoModel;

import java.util.List;

public class ProductsResponseModel {
    List<ProductDtoModel> products;
    String[] categories;

    public ProductsResponseModel(List<ProductDtoModel> products, String[] categories) {
        this.products = products;
        this.categories = categories;
    }

    public List<ProductDtoModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDtoModel> products) {
        this.products = products;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }
}
