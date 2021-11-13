package ru.orangemaks.restaurant.Domain.Order;

import ru.orangemaks.restaurant.Models.ProductCategories;
import ru.orangemaks.restaurant.Models.ProductDtoModel;

import java.util.List;

public interface OrderOutputBoundary {
    OrderResponseModel prepareAllProductView(List<ProductDtoModel> productDtoModelList, ProductCategories[] categories);
}
