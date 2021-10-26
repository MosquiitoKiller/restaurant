package ru.orangemaks.restaurant.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.orangemaks.restaurant.Domain.User.Registration.RegistrationRequest;
import ru.orangemaks.restaurant.Domain.User.Registration.UserRegistrationInputBoundary;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    //TODO Bean

    private UserRegistrationInputBoundary userRegistrationInputBoundary;

    public RegistrationController(UserRegistrationInputBoundary userRegistrationInputBoundary) {
        this.userRegistrationInputBoundary = userRegistrationInputBoundary;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView addUser(@Valid  RegistrationRequest userForm) {

        return userRegistrationInputBoundary.save(userForm);
    }
}
