package ru.orangemaks.restaurant.Domain.Admin.Users;

import java.util.HashMap;
import java.util.List;

public interface Admin_UserOutputBoundary {
    HashMap<String,String> prepareEditUserView(UserDtoModel userDtoModel);
    HashMap<String,String> prepareDeletedUserView(UserDtoModel userDtoModel);
    HashMap<String,String> prepareFindedUserView(UserDtoModel userDtoModel);
    HashMap<String,List<UserDtoModel>> convertUsers(String place,List<UserDtoModel> users);
}
