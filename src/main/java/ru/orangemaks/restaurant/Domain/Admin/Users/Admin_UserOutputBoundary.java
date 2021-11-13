package ru.orangemaks.restaurant.Domain.Admin.Users;

import ru.orangemaks.restaurant.Models.UserDtoModel;

import java.util.HashMap;
import java.util.List;

public interface Admin_UserOutputBoundary {
    HashMap<String,String> prepareSuccessEditUserView(UserDtoModel userDtoModel);
    HashMap<String,String> prepareFailEditUserView(UserDtoModel userDtoModel);
    HashMap<String,String> prepareDeletedUserView(UserDtoModel userDtoModel);
    HashMap<String,String> prepareFindedUserView(UserDtoModel userDtoModel);
    HashMap<String,List<UserDtoModel>> convertUsers(String place,List<UserDtoModel> users);
}
