package ru.orangemaks.restaurant.Domain.Admin.Users;

public class EditUserRequestModel {
    String username;
    String ROLE_USER;
    String ROLE_ADMIN;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getROLE_USER() {
        return ROLE_USER;
    }

    public void setROLE_USER(String ROLE_USER) {
        this.ROLE_USER = ROLE_USER;
    }

    public String getROLE_ADMIN() {
        return ROLE_ADMIN;
    }

    public void setROLE_ADMIN(String ROLE_ADMIN) {
        this.ROLE_ADMIN = ROLE_ADMIN;
    }
}
