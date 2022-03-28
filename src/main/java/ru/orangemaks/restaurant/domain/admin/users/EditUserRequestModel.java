package ru.orangemaks.restaurant.domain.admin.users;

public class EditUserRequestModel {
    String username;
    String roleUser;
    String roleAdmin;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }

    public String getRoleAdmin() {
        return roleAdmin;
    }

    public void setRoleAdmin(String roleAdmin) {
        this.roleAdmin = roleAdmin;
    }
}
