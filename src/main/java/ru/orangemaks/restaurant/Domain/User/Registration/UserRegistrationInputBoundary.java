package ru.orangemaks.restaurant.Domain.User.Registration;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public interface UserRegistrationInputBoundary extends UserDetailsService {
    RegistrationResponseModel save(RegistrationRequest registrationRequest);
}
