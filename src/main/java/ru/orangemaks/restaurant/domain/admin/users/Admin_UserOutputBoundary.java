package ru.orangemaks.restaurant.domain.admin.users;

import ru.orangemaks.restaurant.models.UserDtoModel;

import java.util.List;

public interface Admin_UserOutputBoundary {
    boolean prepareSuccessEditUserView(UserDtoModel userDtoModel);
    boolean prepareFailEditUserView(UserDtoModel userDtoModel);
    UserDtoModel prepareDeletedUserView(UserDtoModel userDtoModel);
    UserDtoModel prepareFindedUserView(UserDtoModel userDtoModel);
    List<UserDtoModel> convertUsers(List<UserDtoModel> users);
}
