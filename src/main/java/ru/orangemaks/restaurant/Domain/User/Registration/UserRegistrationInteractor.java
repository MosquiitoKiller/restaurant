package ru.orangemaks.restaurant.Domain.User.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.orangemaks.restaurant.Entities.Role;
import ru.orangemaks.restaurant.Entities.User;
import ru.orangemaks.restaurant.Models.RoleCategories;

import java.util.Collections;
import java.util.HashMap;


public class UserRegistrationInteractor implements UserRegistrationInputBoundary {
    UserDataAccess userDataAccess;

    UserRegistrationOutputBoundary userRegistrationOutputBoundary;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserRegistrationInteractor(UserDataAccess userDataAccess, UserRegistrationOutputBoundary userRegistrationOutputBoundary) {
        this.userDataAccess = userDataAccess;
        this.userRegistrationOutputBoundary = userRegistrationOutputBoundary;
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
