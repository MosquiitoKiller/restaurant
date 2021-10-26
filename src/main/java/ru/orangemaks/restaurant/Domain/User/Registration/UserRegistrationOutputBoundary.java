package ru.orangemaks.restaurant.Domain.User.Registration;

import org.springframework.web.servlet.ModelAndView;

public interface UserRegistrationOutputBoundary {
    ModelAndView prepareSuccessView(RegistrationResponseModel registrationResponseModel);
    ModelAndView prepareFailView(RegistrationResponseModel registrationResponseModel);
}
