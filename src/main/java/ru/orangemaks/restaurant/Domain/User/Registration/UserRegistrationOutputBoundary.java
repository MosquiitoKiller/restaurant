package ru.orangemaks.restaurant.Domain.User.Registration;

import java.util.HashMap;

public interface UserRegistrationOutputBoundary {
    HashMap<String,String> prepareSuccessView();
    HashMap<String,String> prepareFailView(RegistrationResponseModel registrationResponseModel);
}
