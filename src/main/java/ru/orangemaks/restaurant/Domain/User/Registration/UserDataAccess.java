package ru.orangemaks.restaurant.Domain.User.Registration;

import ru.orangemaks.restaurant.Entities.User;

public interface UserDataAccess {
    void save(User user);
    User findByUsername(String username);
}
