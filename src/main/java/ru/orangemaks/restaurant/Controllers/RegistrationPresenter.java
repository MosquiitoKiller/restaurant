package ru.orangemaks.restaurant.Controllers;

import ru.orangemaks.restaurant.Domain.User.Registration.RegistrationResponseModel;
import ru.orangemaks.restaurant.Domain.User.Registration.UserRegistrationOutputBoundary;

import java.util.HashMap;

public class RegistrationPresenter implements UserRegistrationOutputBoundary {
    @Override
    public HashMap<String,String> prepareSuccessView() {
        return new HashMap<String,String>();
    }

    @Override
    public HashMap<String,String> prepareFailView(RegistrationResponseModel registrationResponseModel) {
        HashMap<String,String> viewModel = new HashMap<>();
        if(registrationResponseModel.usernameError) viewModel.put("usernameError","user with this username already exist");
        if(registrationResponseModel.passwordError) viewModel.put("passwordError","password not confirm");
        return viewModel;
    }
}
