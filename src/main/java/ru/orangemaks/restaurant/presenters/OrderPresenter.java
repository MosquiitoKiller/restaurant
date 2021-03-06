package ru.orangemaks.restaurant.presenters;

import ru.orangemaks.restaurant.domain.order.BasketResponseModel;
import ru.orangemaks.restaurant.domain.order.OrderOutputBoundary;
import ru.orangemaks.restaurant.domain.order.MenuResponseModel;
import ru.orangemaks.restaurant.models.ProductCategories;
import ru.orangemaks.restaurant.models.ProductDtoModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class OrderPresenter implements OrderOutputBoundary {
    @Override
    public MenuResponseModel prepareAllProductView(List<ProductDtoModel> productDtoModelList,
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
        return new MenuResponseModel(menu, categories);
    }

    @Override
    public BasketResponseModel prepareBasket(List<ProductDtoModel> productDtoModels) {
        return new BasketResponseModel(productDtoModels);
    }

    @Override
    public boolean prepareFailedFormOrder() {
        return false;
    }

    @Override
    public boolean prepareSuccessFormOrder() {
        return true;
    }


}
