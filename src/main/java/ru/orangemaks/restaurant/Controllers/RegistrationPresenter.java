package ru.orangemaks.restaurant.Controllers;

import org.springframework.web.servlet.ModelAndView;
import ru.orangemaks.restaurant.Domain.User.Registration.RegistrationResponseModel;
import ru.orangemaks.restaurant.Domain.User.Registration.UserRegistrationOutputBoundary;

public class RegistrationPresenter implements UserRegistrationOutputBoundary {
    ModelAndView modelAndView = new ModelAndView("registration");
    @Override
    public ModelAndView prepareSuccessView(RegistrationResponseModel registrationResponseModel) {
        return modelAndView;
    }

    @Override
    public ModelAndView prepareFailView(RegistrationResponseModel registrationResponseModel) {
        if(registrationResponseModel.usernameError) modelAndView.addObject("usernameError","user with this username already exist");
        if(registrationResponseModel.passwordError) modelAndView.addObject("passwordError","password not confirm");
        return modelAndView;
    }
}
