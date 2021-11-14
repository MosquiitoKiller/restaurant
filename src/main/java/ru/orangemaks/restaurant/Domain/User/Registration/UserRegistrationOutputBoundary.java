package ru.orangemaks.restaurant.Domain.User.Registration;

import java.util.HashMap;

public interface UserRegistrationOutputBoundary {
    RegistrationResponseModel prepareSuccessView();
    RegistrationResponseModel prepareFailView(RegistrationResponseModel registrationResponseModel);
}
