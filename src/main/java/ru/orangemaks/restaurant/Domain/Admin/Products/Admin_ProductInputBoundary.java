package ru.orangemaks.restaurant.Domain.Admin.Products;

import org.springframework.stereotype.Component;
import ru.orangemaks.restaurant.Models.ProductDtoModel;

@Component
public interface Admin_ProductInputBoundary {
    ProductsResponseModel getAll();
    boolean createProduct(CreateProductRequestModel createProductRequestModel);
    ProductsResponseModel filterProducts(FilterProductRequestModel filterProductRequestModel);
    ProductDtoModel findConcreteProduct(Long id);
    boolean editProduct(Long id, EditProductRequestModel editProductRequestModel);
    ProductDtoModel deleteProduct(Long id);
}
