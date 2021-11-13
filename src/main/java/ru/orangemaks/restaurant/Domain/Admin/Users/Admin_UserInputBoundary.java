package ru.orangemaks.restaurant.Domain.Admin.Users;

import org.springframework.stereotype.Component;
import ru.orangemaks.restaurant.Models.UserDtoModel;

import java.util.HashMap;
import java.util.List;

@Component
public interface Admin_UserInputBoundary {
    HashMap<String,List<UserDtoModel>> getAll();
    HashMap<String,String> findConcreteUser(Long id);
    HashMap<String,String> editUser(Long id, EditUserRequestModel editUserRequestModel);
    HashMap<String,List<UserDtoModel>> filterUsers(FilterUserRequestModel filterUserRequestModel);
    HashMap<String,String> deleteUser(Long id);
}
