package ru.orangemaks.restaurant.domain.order;

import ru.orangemaks.restaurant.models.ProductCategories;
import ru.orangemaks.restaurant.models.ProductDtoModel;

import java.util.HashMap;
import java.util.List;

public class MenuResponseModel {
    HashMap<ProductCategories,List<ProductDtoModel>> products;
    ProductCategories[] categories;

    public MenuResponseModel(HashMap<ProductCategories, List<ProductDtoModel>> products, ProductCategories[] categories) {
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
