package ru.orangemaks.restaurant.Domain.Admin.Products;

import ru.orangemaks.restaurant.Models.ProductDtoModel;

import java.util.HashMap;
import java.util.List;

public interface Admin_ProductOutputBoundary {
    HashMap<String, List<ProductDtoModel>> prepareProducts(List<ProductDtoModel> productDtoModels);
    HashMap<String,String> prepareSuccessAddProductView(ProductDtoModel productDtoModel);
    HashMap<String,String> prepareFailAddProductView();
    HashMap<String,String> prepareSuccessEditProductView(ProductDtoModel productDtoModel);
    HashMap<String,String> prepareDeletedProductView(ProductDtoModel productDtoModel);
    HashMap<String,ProductDtoModel> prepareFindedProductView(ProductDtoModel productDtoModel);
}
