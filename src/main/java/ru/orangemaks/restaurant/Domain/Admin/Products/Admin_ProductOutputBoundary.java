package ru.orangemaks.restaurant.Domain.Admin.Products;

import ru.orangemaks.restaurant.Models.ProductCategories;
import ru.orangemaks.restaurant.Models.ProductDtoModel;

import java.util.List;

public interface Admin_ProductOutputBoundary {
    ProductsResponseModel prepareProducts(List<ProductDtoModel> productDtoModels, ProductCategories[] productCategories);
    boolean prepareSuccessAddProductView(ProductDtoModel productDtoModel);
    boolean prepareFailAddProductView();
    boolean prepareSuccessEditProductView(ProductDtoModel productDtoModel);
    ProductDtoModel prepareDeletedProductView(ProductDtoModel productDtoModel);
    ProductDtoModel prepareFindedProductView(ProductDtoModel productDtoModel);
}
