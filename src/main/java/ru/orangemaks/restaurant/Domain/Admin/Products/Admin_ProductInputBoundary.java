package ru.orangemaks.restaurant.Domain.Admin.Products;

import org.springframework.stereotype.Component;
import ru.orangemaks.restaurant.Models.ProductDtoModel;

import java.util.HashMap;
import java.util.List;

@Component
public interface Admin_ProductInputBoundary {
    HashMap<String,List<ProductDtoModel>> getAll();
    HashMap<String,String> createProduct(CreateProductRequestModel createProductRequestModel);
    HashMap<String, List<ProductDtoModel>> filterProducts(FilterProductRequestModel filterProductRequestModel);
    HashMap<String,ProductDtoModel> findConcreteProduct(Long id);
    HashMap<String,String> editProduct(Long id, EditProductRequestModel editProductRequestModel);
    HashMap<String,String> deleteProduct(Long id);
}
