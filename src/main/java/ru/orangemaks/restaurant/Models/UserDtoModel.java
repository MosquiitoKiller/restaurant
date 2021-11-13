package ru.orangemaks.restaurant.Models;

import ru.orangemaks.restaurant.Entities.Role;
import ru.orangemaks.restaurant.Entities.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDtoModel implements Serializable {
    private Long id;
    private String username;
    private List<String> roles;

    public UserDtoModel(Long id, String username, List<String> roles) {
        this.id = id;
        this.username = username;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }


    public static List<UserDtoModel> listUsersMapper(List<User> users){
        List<UserDtoModel> userDtoModels = new ArrayList<>();
        for (User user: users){
            userDtoModels.add(userMapper(user));
        }
        return userDtoModels;
    }

    public static UserDtoModel userMapper(User user){
        List<String> roles = new ArrayList<>();
        for(Role role:user.getRoles()){
            roles.add(role.getName());
        }
        return new UserDtoModel(user.getId(), user.getUsername(), roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id + ", username=" + username+
                '}';
    }
}
