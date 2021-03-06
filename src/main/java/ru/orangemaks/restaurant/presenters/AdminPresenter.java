package ru.orangemaks.restaurant.presenters;

import ru.orangemaks.restaurant.domain.admin.products.Admin_ProductOutputBoundary;
import ru.orangemaks.restaurant.domain.admin.products.ProductsResponseModel;
import ru.orangemaks.restaurant.models.ProductCategories;
import ru.orangemaks.restaurant.models.ProductDtoModel;
import ru.orangemaks.restaurant.domain.admin.users.Admin_UserOutputBoundary;
import ru.orangemaks.restaurant.models.UserDtoModel;

import java.util.List;

public class AdminPresenter implements Admin_UserOutputBoundary, Admin_ProductOutputBoundary {

    @Override
    public boolean prepareSuccessEditUserView(UserDtoModel userDtoModel) {
        return true;
    }

    @Override
    public boolean prepareFailEditUserView(UserDtoModel userDtoModel) {
        return false;
    }

    @Override
    public UserDtoModel prepareDeletedUserView(UserDtoModel userDtoModel) {
        return userDtoModel;
    }

    @Override
    public UserDtoModel prepareFindedUserView(UserDtoModel userDtoModel) {
        return userDtoModel;
    }

    @Override
    public List<UserDtoModel> convertUsers(List<UserDtoModel> users) {
        return users;
    }

    @Override
    public ProductsResponseModel prepareProducts(List<ProductDtoModel> productDtoModels, ProductCategories[] productCategories) {
        String[] categories = new String[productCategories.length];
        for (int i=0;i<productCategories.length;++i) {
            categories[i] = productCategories[i].getCategory();
        }
        return new ProductsResponseModel(productDtoModels,categories);
    }

    @Override
    public boolean prepareSuccessAddProductView(ProductDtoModel productDtoModel) {
        return true;
    }

    @Override
    public boolean prepareFailAddProductView() {
        return false;
    }

    @Override
    public boolean prepareSuccessEditProductView(ProductDtoModel productDtoModel) {
        return true;
    }

    @Override
    public ProductDtoModel prepareDeletedProductView(ProductDtoModel productDtoModel) {
        return productDtoModel;
    }

    @Override
    public ProductDtoModel prepareFindedProductView(ProductDtoModel productDtoModel) {
        return productDtoModel;
    }
}
