package ru.orangemaks.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.orangemaks.restaurant.entities.User;

import java.util.Optional;

/**
 * data access for the User object
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    /**
     * find user by username
     * @param username username
     * @return user by username
     */
    User findByUsername(String username);

    /**
     * find user by id
     * @param id id
     * @return user by id
     */
    Optional<User> findById(Long id);
}
