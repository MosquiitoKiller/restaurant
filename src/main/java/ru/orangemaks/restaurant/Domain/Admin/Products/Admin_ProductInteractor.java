package ru.orangemaks.restaurant.Domain.Admin.Products;

import ru.orangemaks.restaurant.Entities.Product;
import ru.orangemaks.restaurant.Models.ProductCategories;
import ru.orangemaks.restaurant.Models.ProductDtoModel;

import java.util.List;

public class Admin_ProductInteractor implements Admin_ProductInputBoundary {
    Admin_ProductDataAccess admin_productDataAccess;

    Admin_ProductOutputBoundary admin_productOutputBoundary;

    public Admin_ProductInteractor(Admin_ProductDataAccess admin_productDataAccess,
                                   Admin_ProductOutputBoundary admin_productOutputBoundary) {
        this.admin_productDataAccess = admin_productDataAccess;
        this.admin_productOutputBoundary = admin_productOutputBoundary;
    }

    @Override
    public ProductsResponseModel getAll() {
        List<Product> products = admin_productDataAccess.getAll();
        return admin_productOutputBoundary
                .prepareProducts(ProductDtoModel.listProductMapper(products), ProductCategories.values());
    }

    @Override
    public boolean createProduct(CreateProductRequestModel createProductRequestModel) {
        if (createProductRequestModel.getName().equals("") || createProductRequestModel.getPrice() == null
                || createProductRequestModel.getCategoryAdd().equals("") || createProductRequestModel.getDescription().equals("")
                || createProductRequestModel.getImg().equals("")) {
            return admin_productOutputBoundary.prepareFailAddProductView();
        }
        Product product = new Product(createProductRequestModel.getName(),
                createProductRequestModel.getPrice(),
                createProductRequestModel.getCategoryAdd(),
                createProductRequestModel.getDescription(),
                createProductRequestModel.getImg());
        admin_productDataAccess.save(product);
        return admin_productOutputBoundary.prepareSuccessAddProductView(ProductDtoModel.productMapper(product));
    }

    @Override
    public ProductsResponseModel filterProducts(FilterProductRequestModel filterProductRequestModel) {
        List<Product> products = admin_productDataAccess.filter(filterProductRequestModel.getId(),
                filterProductRequestModel.getName(),
                filterProductRequestModel.getCategoryFilter());
        return admin_productOutputBoundary
                .prepareProducts(ProductDtoModel.listProductMapper(products), ProductCategories.values());
    }

    @Override
    public ProductDtoModel findConcreteProduct(Long id) {
        Product product = admin_productDataAccess.findById(id);
        return admin_productOutputBoundary.prepareFindedProductView(ProductDtoModel.productMapper(product));
    }

    @Override
    public boolean editProduct(Long id, EditProductRequestModel editProductRequestModel) {
        Product product = admin_productDataAccess.findById(id);
        if(!editProductRequestModel.getName().equals("")) product.setName(editProductRequestModel.getName());
        if(editProductRequestModel.getPrice()!=null) product.setPrice(editProductRequestModel.getPrice());
        if(!editProductRequestModel.getCategory().equals("")) product.setCategory(editProductRequestModel.getCategory());
        if(!editProductRequestModel.getDescription().equals("")) product.setDescription(editProductRequestModel.getDescription());
        if(!editProductRequestModel.getImg().equals("")) product.setImg(editProductRequestModel.getImg());
        admin_productDataAccess.save(product);
        return admin_productOutputBoundary.prepareSuccessEditProductView(ProductDtoModel.productMapper(product));
    }

    @Override
    public ProductDtoModel deleteProduct(Long id) {
        Product product = admin_productDataAccess.deleteById(id);
        return admin_productOutputBoundary.prepareDeletedProductView(ProductDtoModel.productMapper(product));
    }
}
