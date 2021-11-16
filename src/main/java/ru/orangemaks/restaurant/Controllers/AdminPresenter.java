package ru.orangemaks.restaurant.Controllers;

import ru.orangemaks.restaurant.Domain.Admin.Products.Admin_ProductOutputBoundary;
import ru.orangemaks.restaurant.Models.ProductDtoModel;
import ru.orangemaks.restaurant.Domain.Admin.Users.Admin_UserOutputBoundary;
import ru.orangemaks.restaurant.Models.UserDtoModel;

import java.util.HashMap;
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
    public HashMap<String, List<ProductDtoModel>> prepareProducts(List<ProductDtoModel> productDtoModels) {
        HashMap<String,List<ProductDtoModel>> viewModel = new HashMap<>();
        viewModel.put("allProducts",productDtoModels);
        return viewModel;
    }

    @Override
    public HashMap<String, String> prepareSuccessAddProductView(ProductDtoModel productDtoModel) {
        HashMap<String,String> viewModel = new HashMap<>();
        viewModel.put("operationStatus","Продукт успешно добвлен");
        return viewModel;
    }

    @Override
    public HashMap<String, String> prepareFailAddProductView() {
        HashMap<String,String> viewModel = new HashMap<>();
        viewModel.put("operationStatus","Перед добавлением заполните все поля");
        return viewModel;
    }

    @Override
    public HashMap<String, String> prepareSuccessEditProductView(ProductDtoModel productDtoModel) {
        HashMap<String,String> viewModel = new HashMap<>();
        viewModel.put("editStatus","Продукт успешно изменен");
        return viewModel;
    }

    @Override
    public HashMap<String, String> prepareDeletedProductView(ProductDtoModel productDtoModel) {
        HashMap<String,String> viewModel = new HashMap<>();
        viewModel.put("operationStatus","Пользователь успешно удален");
        return viewModel;
    }

    @Override
    public HashMap<String, ProductDtoModel> prepareFindedProductView(ProductDtoModel productDtoModel) {
        HashMap<String,ProductDtoModel> viewModel = new HashMap<>();
        viewModel.put("product",productDtoModel);
        return viewModel;
    }
}
