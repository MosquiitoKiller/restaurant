package ru.orangemaks.restaurant.Domain.Order;

import ru.orangemaks.restaurant.Models.ProductCategories;
import ru.orangemaks.restaurant.Models.ProductDtoModel;

import java.util.List;

public interface OrderOutputBoundary {
    MenuResponseModel prepareAllProductView(List<ProductDtoModel> productDtoModelList, ProductCategories[] categories);
    BasketResponseModel prepareBasket(List<ProductDtoModel> productDtoModels);
    boolean prepareFailedFormOrder();
    boolean prepareSuccessFormOrder();
}
