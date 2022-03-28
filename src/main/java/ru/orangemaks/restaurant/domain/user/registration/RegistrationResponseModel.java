package ru.orangemaks.restaurant.domain.user.registration;


public class RegistrationResponseModel {
    public boolean usernameError;
    public boolean passwordError;

    public RegistrationResponseModel(boolean usernameError, boolean passwordError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
    }
}
