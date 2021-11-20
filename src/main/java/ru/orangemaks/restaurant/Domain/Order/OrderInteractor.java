package ru.orangemaks.restaurant.Domain.Order;

import ru.orangemaks.restaurant.Entities.Product;
import ru.orangemaks.restaurant.Models.ProductCategories;
import ru.orangemaks.restaurant.Models.ProductDtoModel;

import java.util.ArrayList;
import java.util.List;

public class OrderInteractor implements OrderInputBoundary{

    private final OrderOutputBoundary orderOutputBoundary;
    private final OrderDataAccess orderDataAccess;

    public OrderInteractor(OrderOutputBoundary orderOutputBoundary, OrderDataAccess orderDataAccess) {
        this.orderOutputBoundary = orderOutputBoundary;
        this.orderDataAccess = orderDataAccess;
    }

    @Override
    public OrderResponseModel getAll() {
        List<Product> products = orderDataAccess.getAll();
        return orderOutputBoundary.prepareAllProductView(ProductDtoModel.listProductMapper(products), ProductCategories.values());
    }

    @Override
    public BasketResponseModel getProductsById(BasketRequestModel basketRequestModel) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < basketRequestModel.productsId.size(); i++) {
            products.add(orderDataAccess.findById(basketRequestModel.productsId.get(i)));
        }
        return orderOutputBoundary.prepareBasket(ProductDtoModel.listProductMapper(products));
    }
}
