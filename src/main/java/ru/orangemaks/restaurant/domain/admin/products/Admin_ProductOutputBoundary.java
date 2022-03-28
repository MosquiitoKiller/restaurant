package ru.orangemaks.restaurant.domain.admin.products;

import ru.orangemaks.restaurant.models.ProductCategories;
import ru.orangemaks.restaurant.models.ProductDtoModel;

import java.util.List;

public interface Admin_ProductOutputBoundary {
    ProductsResponseModel prepareProducts(List<ProductDtoModel> productDtoModels, ProductCategories[] productCategories);
    boolean prepareSuccessAddProductView(ProductDtoModel productDtoModel);
    boolean prepareFailAddProductView();
    boolean prepareSuccessEditProductView(ProductDtoModel productDtoModel);
    ProductDtoModel prepareDeletedProductView(ProductDtoModel productDtoModel);
    ProductDtoModel prepareFindedProductView(ProductDtoModel productDtoModel);
}
