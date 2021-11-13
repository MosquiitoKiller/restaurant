package ru.orangemaks.restaurant.Controllers;

import ru.orangemaks.restaurant.Domain.Admin.Products.Admin_ProductOutputBoundary;
import ru.orangemaks.restaurant.Models.ProductDtoModel;
import ru.orangemaks.restaurant.Domain.Admin.Users.Admin_UserOutputBoundary;
import ru.orangemaks.restaurant.Models.UserDtoModel;

import java.util.HashMap;
import java.util.List;

public class AdminPresenter implements Admin_UserOutputBoundary, Admin_ProductOutputBoundary {

    @Override
    public HashMap<String, String> prepareSuccessEditUserView(UserDtoModel userDtoModel) {
        HashMap<String,String> viewModel = new HashMap<>();
        viewModel.put("editStatus","Пользователь успешно изменен");
        viewModel.putAll(prepareFindedUserView(userDtoModel));
        return viewModel;
    }

    @Override
    public HashMap<String, String> prepareFailEditUserView(UserDtoModel userDtoModel) {
        HashMap<String,String> viewModel = new HashMap<>();
        viewModel.put("editStatus","Пользователь с таким именем уже существует");
        viewModel.putAll(prepareFindedUserView(userDtoModel));
        return viewModel;
    }

    @Override
    public HashMap<String, String> prepareDeletedUserView(UserDtoModel userDtoModel) {
        HashMap<String,String> viewModel = new HashMap<>();
        viewModel.put("deleteSuccess","Пользователь "+userDtoModel.toString()+" успешно удален");
        return viewModel;
    }

    @Override
    public HashMap<String, String> prepareFindedUserView(UserDtoModel userDtoModel) {
        HashMap<String,String> viewModel = new HashMap<>();
        viewModel.put("userId",String.valueOf(userDtoModel.getId()));
        viewModel.put("username",userDtoModel.getUsername());
        viewModel.put("ROLE_USER",String.valueOf(userDtoModel.getRoles().contains("ROLE_USER")));
        viewModel.put("ROLE_ADMIN",String.valueOf(userDtoModel.getRoles().contains("ROLE_ADMIN")));
        return viewModel;
    }

    @Override
    public HashMap<String, List<UserDtoModel>> convertUsers(String place,List<UserDtoModel> users) {
        HashMap<String,List<UserDtoModel>> viewModel = new HashMap<>();
        viewModel.put(place,users);
        return viewModel;
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
