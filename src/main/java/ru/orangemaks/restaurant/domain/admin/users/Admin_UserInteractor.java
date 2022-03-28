package ru.orangemaks.restaurant.domain.admin.users;

import ru.orangemaks.restaurant.entities.Role;
import ru.orangemaks.restaurant.entities.User;
import ru.orangemaks.restaurant.models.RoleCategories;
import ru.orangemaks.restaurant.models.UserDtoModel;

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
    public List<UserDtoModel> getAll() {
        List<User> users = admin_userDataAccess.getAll();
        List<UserDtoModel> userDtoModels = UserDtoModel.listUsersMapper(users);
        return admin_userOutputBoundary.convertUsers(userDtoModels);
    }

    @Override
    public UserDtoModel findConcreteUser(Long id) {
        User user = admin_userDataAccess.findById(id);
        UserDtoModel userDtoModel = UserDtoModel.userMapper(user);
        return admin_userOutputBoundary.prepareFindedUserView(userDtoModel);
    }

    @Override
    public boolean editUser(Long id, EditUserRequestModel editUserRequestModel) {
        User user = admin_userDataAccess.findById(id);
        User userByName = admin_userDataAccess.findByUsername(editUserRequestModel.getUsername());
        if(userByName!=null && userByName!=user)
            return admin_userOutputBoundary.prepareFailEditUserView(UserDtoModel.userMapper(user));

        if (!editUserRequestModel.getUsername().equals("")) user.setUsername(editUserRequestModel.getUsername());

        List<Role> roles = user.getRoles();
        boolean alreadyExistRoleUser = false;
        boolean alreadyExistRoleAdmin = false;
        for (Role role:user.getRoles()){
            if (role.getName().equals(RoleCategories.ROLE_USER.name())) {
                alreadyExistRoleUser = true;
            }
            if (role.getName().equals(RoleCategories.ROLE_ADMIN.name())) {
                alreadyExistRoleAdmin = true;
            }
        }
        if (!editUserRequestModel.getRoleUser().equals("")){
            if (!alreadyExistRoleUser) roles.add(admin_roleDataAccess.findById(RoleCategories.ROLE_USER.getId()));
        }
        else{
            if(alreadyExistRoleUser) roles.remove(admin_roleDataAccess.findById(RoleCategories.ROLE_USER.getId()));
        }
        if (!editUserRequestModel.getRoleAdmin().equals("")){
            if (!alreadyExistRoleAdmin) roles.add(admin_roleDataAccess.findById(RoleCategories.ROLE_ADMIN.getId()));
        }
        else{
            if (alreadyExistRoleAdmin) roles.remove(admin_roleDataAccess.findById(RoleCategories.ROLE_ADMIN.getId()));
        }
        user.setRoles(roles);
        admin_userDataAccess.save(user);
        UserDtoModel userDtoModel = UserDtoModel.userMapper(user);
        return admin_userOutputBoundary.prepareSuccessEditUserView(userDtoModel);
    }

    @Override
    public List<UserDtoModel> filterUsers(FilterUserRequestModel filterUserRequestModel) {
        List<User> users = admin_userDataAccess.filter(filterUserRequestModel.getId(),
                filterUserRequestModel.getUsername(),
                filterUserRequestModel.getRoleUser(),
                filterUserRequestModel.getRoleAdmin());
        List<UserDtoModel> userDtoModels = UserDtoModel.listUsersMapper(users);
        return admin_userOutputBoundary.convertUsers(userDtoModels);
    }

    @Override
    public UserDtoModel deleteUser(Long id) {
        User user = admin_userDataAccess.deleteById(id);
        UserDtoModel userDtoModel = UserDtoModel.userMapper(user);
        return admin_userOutputBoundary.prepareDeletedUserView(userDtoModel);
    }
}
