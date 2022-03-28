package ru.orangemaks.restaurant.domain.user.registration;

import ru.orangemaks.restaurant.entities.User;

public interface UserDataAccess {
    void save(User user);
    User findByUsername(String username);
}
