package ru.orangemaks.restaurant.Domain.Admin.Users;

import ru.orangemaks.restaurant.Entities.Role;
import ru.orangemaks.restaurant.Entities.User;
import ru.orangemaks.restaurant.Models.UserDtoModel;

import java.util.*;

public class Admin_UserInteractor implements Admin_UserInputBoundary {
    Admin_UserDataAccess admin_userDataAccess;
    Admin_RoleDataAccess admin_roleDataAccess;

    Admin_UserOutputBoundary admin_userOutputBoundary;

    public Admin_UserInteractor(Admin_UserDataAccess admin_userDataAccess,
                                Admin_RoleDataAccess admin_roleDataAccess,
                                Admin_UserOutputBoundary admin_userOutputBoundary) {
        this.admin_userDataAccess = admin_userDataAccess;
        this.admin_roleDataAccess = admin_roleDataAccess;
        this.admin_userOutputBoundary = admin_userOutputBoundary;
    }

    @Override
    public HashMap<String,List<UserDtoModel>> getAll() {
        List<User> users = admin_userDataAccess.getAll();
        List<UserDtoModel> userDtoModels = UserDtoModel.listUsersMapper(users);
        return admin_userOutputBoundary.convertUsers("allUsers",userDtoModels);
    }

    @Override
    public HashMap<String, String> findConcreteUser(Long id) {
        User user = admin_userDataAccess.findById(id);
        UserDtoModel userDtoModel = UserDtoModel.userMapper(user);
        return admin_userOutputBoundary.prepareFindedUserView(userDtoModel);
    }

    @Override
    public HashMap<String, String> editUser(Long id, EditUserRequestModel editUserRequestModel) {
        User user = admin_userDataAccess.findById(id);
        User userByName = admin_userDataAccess.findByUsername(editUserRequestModel.getUsername());
        if(userByName!=null && userByName!=user)
            return admin_userOutputBoundary.prepareFailEditUserView(UserDtoModel.userMapper(user));
        user.setUsername(editUserRequestModel.getUsername());

        List<Role> roles = user.getRoles();
        boolean alreadyExistRoleUser = false;
        for (Role role:user.getRoles()){
            if (role.getName().equals("ROLE_USER")) {
                alreadyExistRoleUser = true;
                break;
            }
        }
        boolean alreadyExistRoleAdmin = false;
        for (Role role:user.getRoles()){
            if (role.getName().equals("ROLE_ADMIN")) {
                alreadyExistRoleAdmin = true;
                break;
            }
        }
        if (editUserRequestModel.getROLE_USER().equals("on")){
            if (!alreadyExistRoleUser) roles.add(admin_roleDataAccess.findById(1L));
        }
        else{
            if(alreadyExistRoleUser) roles.remove(admin_roleDataAccess.findById(1L));
        }
        if (editUserRequestModel.getROLE_ADMIN().equals("on")){
            if (!alreadyExistRoleAdmin) roles.add(admin_roleDataAccess.findById(2L));
        }
        else{
            if (alreadyExistRoleAdmin) roles.remove(admin_roleDataAccess.findById(2L));
        }
        user.setRoles(roles);
        admin_userDataAccess.save(user);
        UserDtoModel userDtoModel = UserDtoModel.userMapper(user);
        return admin_userOutputBoundary.prepareSuccessEditUserView(userDtoModel);
    }

    @Override
    public HashMap<String,List<UserDtoModel>> filterUsers(FilterUserRequestModel filterUserRequestModel) {
        List<User> users = admin_userDataAccess.filter(filterUserRequestModel.getId(),
                filterUserRequestModel.getUsername(),
                filterUserRequestModel.getROLE_USER(),
                filterUserRequestModel.getROLE_ADMIN());
        List<UserDtoModel> userDtoModels = UserDtoModel.listUsersMapper(users);
        return admin_userOutputBoundary.convertUsers("allUsers",userDtoModels);
    }

    @Override
    public HashMap<String,String> deleteUser(Long id) {
        User user = admin_userDataAccess.deleteById(id);
        UserDtoModel userDtoModel = UserDtoModel.userMapper(user);
        return admin_userOutputBoundary.prepareDeletedUserView(userDtoModel);
    }
}
