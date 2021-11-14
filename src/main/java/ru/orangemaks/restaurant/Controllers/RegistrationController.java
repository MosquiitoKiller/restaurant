package ru.orangemaks.restaurant.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.orangemaks.restaurant.Domain.User.Registration.RegistrationRequest;
import ru.orangemaks.restaurant.Domain.User.Registration.RegistrationResponseModel;
import ru.orangemaks.restaurant.Domain.User.Registration.UserRegistrationInputBoundary;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    private final UserRegistrationInputBoundary userRegistrationInputBoundary;

    public RegistrationController(UserRegistrationInputBoundary userRegistrationInputBoundary) {
        this.userRegistrationInputBoundary = userRegistrationInputBoundary;
    }

    @PostMapping("/addUser")
    public RegistrationResponseModel addUser(@RequestBody RegistrationRequest registrationRequest) {
        return userRegistrationInputBoundary.save(registrationRequest);
    }
}
