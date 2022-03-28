package ru.orangemaks.restaurant.domain.user.registration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.orangemaks.restaurant.entities.Role;
import ru.orangemaks.restaurant.entities.User;
import ru.orangemaks.restaurant.models.RoleCategories;

import java.util.Collections;

public class UserRegistrationInteractor implements UserRegistrationInputBoundary {
    UserDataAccess userDataAccess;
    UserRegistrationOutputBoundary userRegistrationOutputBoundary;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRegistrationInteractor(UserDataAccess userDataAccess, UserRegistrationOutputBoundary userRegistrationOutputBoundary, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDataAccess = userDataAccess;
        this.userRegistrationOutputBoundary = userRegistrationOutputBoundary;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public RegistrationResponseModel save(RegistrationRequest registrationRequest) {
        boolean usernameError = userDataAccess.findByUsername(registrationRequest.getUsername())!=null;
        boolean passwordError = !registrationRequest.getPassword().equals(registrationRequest.getPasswordConfirm());
        if(usernameError || passwordError)
            return userRegistrationOutputBoundary.prepareFailView(new RegistrationResponseModel(usernameError,passwordError));

        User user = new User();
        user.setRoles(Collections.singletonList(new Role(RoleCategories.ROLE_USER.getId(), RoleCategories.ROLE_USER.name())));
        user.setUsername(registrationRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(registrationRequest.getPassword()));
        userDataAccess.save(user);
        return userRegistrationOutputBoundary.prepareSuccessView();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDataAccess.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
