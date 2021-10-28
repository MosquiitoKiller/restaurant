package ru.orangemaks.restaurant.Controllers;

import ru.orangemaks.restaurant.Domain.Admin.Users.Admin_UserOutputBoundary;
import ru.orangemaks.restaurant.Domain.Admin.Users.UserDtoModel;
import ru.orangemaks.restaurant.Entities.User;

import java.util.HashMap;
import java.util.List;

public class AdminPresenter implements Admin_UserOutputBoundary {

    @Override
    public HashMap<String, String> prepareEditUserView(UserDtoModel userDtoModel) {
        HashMap<String,String> viewModel = new HashMap<>();
        viewModel.put("editStatus","Пользователь успешно изменен");
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

}
