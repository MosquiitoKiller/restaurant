package ru.orangemaks.restaurant.Controllers;

import ru.orangemaks.restaurant.Domain.User.Registration.RegistrationResponseModel;
import ru.orangemaks.restaurant.Domain.User.Registration.UserRegistrationOutputBoundary;

import java.util.HashMap;

public class RegistrationPresenter implements UserRegistrationOutputBoundary {
    @Override
    public RegistrationResponseModel prepareSuccessView() {
        return new RegistrationResponseModel(false,false);
    }

    @Override
    public RegistrationResponseModel prepareFailView(RegistrationResponseModel registrationResponseModel) {
        return registrationResponseModel;
    }
}
