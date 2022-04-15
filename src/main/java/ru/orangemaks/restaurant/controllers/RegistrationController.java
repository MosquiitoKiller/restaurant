package ru.orangemaks.restaurant.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.orangemaks.restaurant.domain.user.registration.RegistrationRequest;
import ru.orangemaks.restaurant.domain.user.registration.RegistrationResponseModel;
import ru.orangemaks.restaurant.domain.user.registration.UserRegistrationInputBoundary;

/**
 * Controller for registration
 */
@RestController
public class RegistrationController {

    /**
     * UserRegistrationInteractor
     */
    private final UserRegistrationInputBoundary userRegistrationInputBoundary;

    public RegistrationController(UserRegistrationInputBoundary userRegistrationInputBoundary) {
        this.userRegistrationInputBoundary = userRegistrationInputBoundary;
    }

    /**
     * create new user
     * @param registrationRequest registration data
     * @return registration status
     */
    @PostMapping("/addUser")
    public RegistrationResponseModel addUser(@RequestBody RegistrationRequest registrationRequest) {
        return userRegistrationInputBoundary.save(registrationRequest);
    }
}
