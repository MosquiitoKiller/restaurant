package ru.orangemaks.restaurant.domain.user.registration;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public interface UserRegistrationInputBoundary extends UserDetailsService {
    RegistrationResponseModel save(RegistrationRequest registrationRequest);
}
