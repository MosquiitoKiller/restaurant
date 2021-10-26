package ru.orangemaks.restaurant.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
