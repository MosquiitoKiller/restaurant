package ru.orangemaks.restaurant.domain.order;

import ru.orangemaks.restaurant.models.ProductCategories;
import ru.orangemaks.restaurant.models.ProductDtoModel;

import java.util.List;

public interface OrderOutputBoundary {
    MenuResponseModel prepareAllProductView(List<ProductDtoModel> productDtoModelList, ProductCategories[] categories);
    BasketResponseModel prepareBasket(List<ProductDtoModel> productDtoModels);
    boolean prepareFailedFormOrder();
    boolean prepareSuccessFormOrder();
}
