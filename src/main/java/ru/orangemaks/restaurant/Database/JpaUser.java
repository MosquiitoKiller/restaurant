package ru.orangemaks.restaurant.Database;

import ru.orangemaks.restaurant.Domain.User.Registration.UserDataAccess;
import ru.orangemaks.restaurant.Entities.User;

public class JpaUser implements UserDataAccess {


    UserRepository userRepository;

    public JpaUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
