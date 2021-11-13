package ru.orangemaks.restaurant.Controllers;

import ru.orangemaks.restaurant.Domain.Order.OrderOutputBoundary;
import ru.orangemaks.restaurant.Domain.Order.OrderResponseModel;
import ru.orangemaks.restaurant.Models.ProductCategories;
import ru.orangemaks.restaurant.Models.ProductDtoModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class OrderPresenter implements OrderOutputBoundary {
    @Override
    public OrderResponseModel prepareAllProductView(List<ProductDtoModel> productDtoModelList,
                                                    ProductCategories[] categories) {
        HashMap<ProductCategories,List<ProductDtoModel>> menu = new HashMap<>();
        for (ProductCategories p : categories) menu.put(p, new ArrayList<>());

        for (ProductDtoModel product : productDtoModelList) {
            ProductCategories p = null;
            for (ProductCategories productCategories : categories){
                if (productCategories.getCategory().equals(product.getCategory())){
                    p = productCategories;
                    break;
                }
            }
            menu.get(p).add(product);
        }
        return new OrderResponseModel(menu, categories);
    }
}
