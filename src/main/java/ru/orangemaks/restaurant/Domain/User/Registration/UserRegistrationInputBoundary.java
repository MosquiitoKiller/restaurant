package ru.orangemaks.restaurant.Domain.User.Registration;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public interface UserRegistrationInputBoundary extends UserDetailsService {
    ModelAndView save(RegistrationRequest registrationRequest);
}
