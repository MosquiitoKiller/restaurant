package ru.orangemaks.restaurant.presenters;

import ru.orangemaks.restaurant.domain.user.registration.RegistrationResponseModel;
import ru.orangemaks.restaurant.domain.user.registration.UserRegistrationOutputBoundary;

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
