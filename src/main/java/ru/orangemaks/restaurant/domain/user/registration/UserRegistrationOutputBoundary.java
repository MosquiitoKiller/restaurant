package ru.orangemaks.restaurant.domain.user.registration;

public interface UserRegistrationOutputBoundary {
    RegistrationResponseModel prepareSuccessView();
    RegistrationResponseModel prepareFailView(RegistrationResponseModel registrationResponseModel);
}
